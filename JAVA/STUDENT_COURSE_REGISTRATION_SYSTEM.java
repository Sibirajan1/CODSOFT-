import java.util.*;
class courses{
String course_id;
String course_name;
String description;
int capacity;
int slots;
String schedule;
courses(String id,String title,String descp,int cap,String sch){
    course_id=id;
    course_name=title;
    description=descp;
    capacity=cap;
    schedule=sch;
    slots=0;
    }  

}
class students{
    int ID;
    String name;
    Map<String,courses> course_reg=new HashMap<>();
    students(int id,String nm){
        ID=id;
        name=nm;
    }
}
class register{
    Map<String,courses> courseslist=new HashMap<>();
    Scanner sc=new Scanner(System.in);
    public void add_Course(courses c){
        courseslist.put(c.course_id,c);
    }
    public void display_courses(){
       for(Map.Entry<String,courses> item:courseslist.entrySet()){
        courses temp=item.getValue();
        System.out.println(temp.course_id+" - "+temp.course_name+" - "+temp.description+" - "+temp.slots+"  - "+temp.schedule+" - "+temp.capacity);            
       }
    }
    public void display_student(Map<Integer,students> studenList){
         int sid; 
        while(true){
        System.out.println("Enter student ID: ");
        sid=sc.nextInt();
        if(!studenList.containsKey(sid)){
            System.out.println("student ID not found!!");
            continue;
            }
            else break;
        }
        students s=studenList.get(sid);
        System.out.println("ID: "+s.ID+" Name: "+s.name+" courses registered: ");
        if(!s.course_reg.isEmpty()){
        for(Map.Entry<String,courses> item:s.course_reg.entrySet()){
            System.out.println("\t"+item.getValue().course_id+" - "+item.getValue().course_name);
           }
        }
        else
            System.out.println("course not registered!!");
    }
    public void drop_course(Map<Integer,students> studenList){
        String cid; int sid; 
        while(true){
        System.out.println("Enter student ID: ");
        sid=sc.nextInt();
        if(!studenList.containsKey(sid)){
            System.out.println("student ID not found!!");
            continue;
            }
            else break;
        }
        sc.nextLine();
        if(studenList.get(sid).course_reg.isEmpty()){
            System.out.println("no courses registered!!!");
                return;        
        }
        while(true){
        System.out.println("Enter course ID to drop: ");
        cid=sc.nextLine();
        
        if(courseslist.containsKey(cid)){
            if(studenList.get(sid).course_reg.containsKey(cid)){
            studenList.get(sid).course_reg.remove(cid);
            courseslist.get(cid).slots--;
              System.out.println("student "+sid+" droped "+cid+" - " +courseslist.get(cid).course_name);
              break;
            }
        
        else{
            System.out.println("course not registered!!");
            break;
            }
        }
        else
            System.out.println("course not found!!");
        }
    }
    public void registering(Map<Integer,students> studenList){
        String cid; int sid; 
        while(true){
        System.out.println("Enter student ID: ");
        sid=sc.nextInt();
        if(!studenList.containsKey(sid)){
            System.out.println("student ID not found!!");
            continue;
            }
            else break;
        }
        sc.nextLine();
        while(true){

        System.out.println("Enter course ID to register course: ");
        cid=sc.nextLine();
        if(courseslist.containsKey(cid)){
            if(studenList.get(sid).course_reg.containsKey(cid)){
                System.out.println("course already registerd");
                continue;
            }
            else{
            if(courseslist.get(cid).capacity>courseslist.get(cid).slots){
                courseslist.get(cid).slots++;
                studenList.get(sid).course_reg.put(cid, courseslist.get(cid));
                System.out.println("student "+studenList.get(sid).name+" registered in "+cid+" - "+courseslist.get(cid).course_name);
                break;
            }
            else{
              System.out.println("no available seats for the course "+cid);
              break;   
            }
           }
        }
        else{
            System.out.println("course ID not found!!");
           continue;
        }

        }
    }

}
public class  STUDENT_COURSE_REGISTRATION_SYSTEM {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        courses c1=new courses("555", "java", "hfjjh", 6, "Monday");
        courses c2=new courses("777", "c++", "hfjjh", 3, "Tuesday");
        courses c3=new courses("222", "c", "hfjjh", 2, "wednesday");
        courses c4=new courses("666", "python", "hfjjh", 6, "thursday");
        courses c5=new courses("333", "os", "hfjjh", 0, "Friday");
        register reg=new register();
        reg.add_Course(c1);
        reg.add_Course(c2);
        reg.add_Course(c3);
        reg.add_Course(c4);
        reg.add_Course(c5);
        Map<Integer,students> student_list=new HashMap<>();
        students s1=new students(56,"sai");
        students s2=new students(53,"devi");
        students s3=new students(52,"sri");
        students s4=new students(55,"nick");
        students s5=new students(57,"tam");
        student_list.put(s1.ID, s1);
        student_list.put(s2.ID, s2);
        student_list.put(s3.ID, s3);
        student_list.put(s4.ID, s4);
        student_list.put(s5.ID, s5);
        int ch=1;
        while(ch!=0){
            System.out.println("Enter 1 to register course, 2 to drop 3 to display student details and 0 to exit: ");
            ch=sc.nextInt();
            switch (ch) {
                case 1:
                    reg.display_courses();
                    reg.registering(student_list);
                    break;
                case 2:
                    reg.display_courses();
                    reg.drop_course(student_list);
                    break;
                case 3:
                     reg.display_student(student_list);
                case 0:
                System.out.println("Exiting!!");
                    break;

                default:
                 System.out.println("Enter valid choice");
                    break;
            }
        
        }
        
    }
}
