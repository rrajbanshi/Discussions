
/*
 Modify the class Account to provide a method called debit that withdraws money from an Account.
  Ensure that the debit amount does not exceed the Account’s balance. If it does, the balance should 
  be left unchanged and the method should print a message indicating ―Debit amount exceeded account 
  balance. Modify class BankAccounts to test method deb
 */
import java.util.*;
class Account{
    double balance;
    String accountHolder;
Account(double balance, String accountHolder){
    this.balance = balance;
    this.accountHolder = accountHolder;

}
Account(){
    this.balance = 0;
    this.accountHolder = "";

}
public void debitAmount(double amount){
     if(amount <= balance){
        balance = balance - amount;
        System.out.println("your new balance is "+ balance);
     }else{
         System.out.println("Debit amount exceeded account balance");
     }
  }
}
public class BankAccountTransaction {
    public static void main(String[] args){
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter the amout you want to withdrawls: ");
     int n = Integer.parseInt(sc.nextLine());
     Account a1 = new Account(1000.0, "rakesh");
     a1.debitAmount(n);
    }
}
