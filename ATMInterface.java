import java.util.Scanner;

class user_account
{
    private float balance;
    user_account( float balance)
    {
        this.balance = balance ;
    }
   public float getbalance()
   {
    return balance ;
   }
   public void deposit(double amount){
    balance += amount;
   }
   public void withdraw( double amount)
   {
    balance -= amount ;
   }
}
 class ATM
 {
   private user_account acc ;
    
   public ATM(user_account acc)
   {
    this.acc = acc ;
   }
   public  void menu(){

   
   System.out.println("WELCOME" );
   System.out.println(" FOLLOWING ARE THE FUNCTIONS YOU CAN PERFORM");
   System.out.println("1.CHECK BALANCE");
   System.out.println("2. DEPOSITE MONEY ");
   System.out.println("3. WITHDRAW MONEY ");
   System.out.println("4. EXIT");
   }

   public void work()
   {
    Scanner s = new Scanner(System.in);
    int choice ;
    double amount;
      
    while(true)
    {
        menu();
        System.out.println("ENTER YOUR CHOICE");
        choice = s.nextInt();

        switch(choice)
        {
            case 1:
             System.out.println("Your balance is Rs. " + acc.getbalance());
                break ;
            
             case 2:
                 System.out.println("How much you want to Deposit");
                amount = s.nextInt();
                if(amount > 0){
                    acc.deposit(amount);
                    System.out.println("Done");
                }
                else
                {
                    System.out.println("Invalid amount");
                }
                break ;
             case 3:
                System.out.println("How much you want to withdraw ");
                amount = s.nextInt();
                if(amount > 0 && amount <= acc.getbalance()){
                    acc.withdraw(amount);
                    System.out.println("your remaining balance is" + acc.getbalance());
                }
                else{
                    System.out.println(" Insuffecient Amount ");
                }
                break ;
             case 4:
                System.out.println("THANK YOU , HAVE A GOOD DAY");
                return ;
        
             default:
                System.out.println("INVALID CHOICE ");
            
        
        }
    }
   }
 }
 public class ATM_interface
 {
    public static void main(String ar[])
    {
        user_account ac = new user_account(20000);
        ATM a = new ATM(ac);
        a.work();
        
    }
 }
 
