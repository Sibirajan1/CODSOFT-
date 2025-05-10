
import java.util.*;
public class cs2 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n,totalmark=0;
        double avg_percent;
        char grade;
        int marks[]=new int[100];
        System.out.println("Enter the numer of subjects: ");
        n=sc.nextInt();
        for(int i=0;i<n;i++){
             System.out.println("Enter the mark of subject "+(i+1)+" out of 100");
             marks[i]=sc.nextInt();
             totalmark+=marks[i];
        }
        avg_percent=totalmark/n;
        if(avg_percent<30)
        grade='F';
        else if(avg_percent>=30 && avg_percent<50)
        grade='D';
        else if(avg_percent>=50 && avg_percent<70)
        grade='C';
        else if(avg_percent>=70 && avg_percent<90)
        grade='B';
        else
        grade='A';
        System.out.println("Total marks obtained for "+n+" subjects = "+totalmark+"/"+(n*100));
        System.out.println("Average percentage = "+avg_percent+"/100");
        System.out.println("GRADE : "+grade);
    }
}
