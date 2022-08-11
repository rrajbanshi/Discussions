/*
 Create a class Account with the following data members: balance, accountHolder. 
 Create two objects with different states. Create a driver class BankAccounts with 
 the main method to create the objects of the Account class.
 */
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
}
public class BankAccount{

    public static void main(String[] args) {
        Account a1 = new Account(1000, "Rakesh");
        Account a2 = new Account(2000, "ram");
        System.out.println("a1.balance = " + a1.balance + "a1.accountHolder = " + a1.accountHolder);
        System.out.println("a2.balance = " + a2.balance + "a2.accountHolder = " + a2.accountHolder);

        
 }
}