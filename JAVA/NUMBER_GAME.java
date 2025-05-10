
import java.util.*;
public class  NUMBER_GAME {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
    Random rand=new Random();
    int choice=1,count=0,won=0;;
    System.out.println("-------Welcome to NUMBER GAME-------");
    System.out.println("!!You have 5 attempts to guess the number in each round\n");
   while(choice==1){
    int num=rand.nextInt(100)+1;

    for(int i=0;i<5;i++){
        System.out.println("\t"+(i+1)+") enter your guess between 1 to 100: " ) ;
        int guess=sc.nextInt();
        if(guess>num+10)
        System.out.println("Your guess is too high. try again");
        else if(guess<num-10)
        System.out.println("Your guess is too low. try again");
        else if(guess<num && guess>num-10)
        System.out.println("Your guess is little lower. try again");
        else if(guess>num && guess<num+10)
        System.out.println("Your guess is little higher. try again");
        else if(guess==num){
        System.out.println("Your guess is correct. you won the round");
        won++;
        break;
        }
    }
    System.out.println("-------ROUND OVER------");
    count++;
    System.out.println("Enter 1 to continue game or 0 to exit: ");
    choice=sc.nextInt();
   } 
   System.out.println("You have won "+won+" out of "+count+" rounds");

    }

}
