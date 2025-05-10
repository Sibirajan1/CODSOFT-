import java.util.*;

 class bank_account{
    int account_number;
    String user_name;
    double balance;
    bank_account(int no,String name,double bal ){
        account_number=no;
        user_name=name;
        balance=bal;
    }   

}
 class ATM_machine{
    Map<Integer,bank_account>accounts=new HashMap<>();
    int cur_acc=-1;
    int index=0;
    ATM_machine(){}
    public boolean access_ATM(int accno){
            if(accounts.containsKey(accno)){   
                cur_acc=accno;         
            return true;
            }       
            return false;
    }
    public void add_account(bank_account ba){
       accounts.put(ba.account_number, ba);
    }
    public void withdraw(double amount){
        if(amount> accounts.get(cur_acc).balance)
            System.out.println("no sufficient balance for withdrawal!!");
            
        else{
            accounts.get(cur_acc).balance-=amount;
            System.out.println("Amount "+amount+" withdrawed\n\t Transaction successfull");
        }
    }
    public void deposite(double amount){
        accounts.get(cur_acc).balance+=amount;
        System.out.println("Amount "+amount+" deposited\n\t Transaction successfull!");

    }
    public void check_balance(){
    System.out.println("Account balance : "+ accounts.get(cur_acc).balance);
    }
    
    }
public class ATM_INTERFACE {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        ATM_machine atm=new ATM_machine();
        bank_account b1=new bank_account(77777,"gnnnnn" , 58350);
        bank_account b2=new bank_account(55555,"sssss" , 76850);
        bank_account b3=new bank_account(88888,"jjjjj" , 89750);
        bank_account b4=new bank_account(44444,"iiiiii" , 46536);
        bank_account b5=new bank_account(33333,"wwwww" , 69863);
        atm.add_account(b1);  atm.add_account(b2);  atm.add_account(b3);  atm.add_account(b4);  atm.add_account(b5);
        int ch=1,acno;
        while(ch!=0){
        System.out.println("Enter account number: ");
        acno=sc.nextInt();
        if(!atm.access_ATM(acno)){
        System.out.println("account not found.Enter valid account number!");
        continue;
        }
        while(ch!=0){
        System.out.println("Enter 1 to withdraw ,2 to deposite money , 3 to check balance and 0 to exit: ");
        ch=sc.nextInt();  
        switch (ch) {
            case 1:
            double amt;
                System.out.println("enter amount to withdraw: ");
                amt=sc.nextDouble();
                atm.withdraw(amt);
                break;
            case 2:
            double amnt;
                System.out.println("enter amount to withdraw: ");
                amnt=sc.nextDouble();
                atm.deposite(amnt);
                break;
            case 3:
                atm.check_balance();
                break;
            case 0:
                atm.cur_acc=-1;
                break;
            default:
            System.out.println("Enter corresponding number for the action!");
                break;
        
            } 
        }
        }
    }
}
