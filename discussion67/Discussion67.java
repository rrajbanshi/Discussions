/*
 The objective is to implement a generic BankAccount class so that any customer can create any type of bank account.
Define an interface AccountType:
interface AccountType {
    void deposit(U amount) {
        // code
    }
    void withdraw(U amount) {
        // code
    }
   void showBalance() {
       // code
    }
}
Implement the interface in two classes - SavingsAccount and CurrentAccount. The SavingsAccount class will show
 the balance along with annual interest @ 4%.

Define a generic class BankAccount where the generic type is bounded to AccountType. The BankAccount class 
will have a generic data member T that will take the form of either SavingsAccount or CurrentAccount.
 The class will have a method called showAccountType().
 */
import java.util.*;

interface AccountType<U>{
    void deposit(U amount);
    void withdraw(U amount);
    void showBalance();
}

class SavingsAccount<T> implements AccountType{
double balance;
static final double rateOfInterest = 0.04;

public SavingsAccount(T balance){
    this.balance = (double)balance;
 }

 @Override 
 public void deposit(Object amount){
    System.out.println("amount deposited: " + amount);
    this.balance += (double)amount;
 }

 @Override
 public void withdraw(Object amt){
    if(balance < 0){
        System.out.println("insufficent funds");
    }
   else{
    System.out.println("amt withdrawl is: " + amt);
    this.balance -= (double)amt;
   }
 }

 @Override
 public void showBalance(){
    this.balance = this.balance * rateOfInterest + this.balance;
    System.out.println("balance: " +balance);
 }
}

 class CurrentAccount<T> implements AccountType{
    double balance;
    public CurrentAccount(T balance){
        this.balance = (double)balance;
    }
    
    @Override
	public void showBalance() {
        
		System.out.println("Current Balance : " + balance );
	}

	@Override
	public void deposit(Object amount) {
		System.out.println("Amound Deposisted: " + amount);
        this.balance += (double)amount;
		
	}

	@Override
	public void withdraw(Object amount) {
        this.balance -= (double)amount;
		System.out.println("Amount withdrawn:: " + amount);
	}


}

class BankAccount<T extends AccountType>{
    T account;
 
    public BankAccount(T account){
        this.account = account;
    }

    public T getaccount() {
		return account;
	}

	public  void showAccaccount() {
    	System.out.println("type of account-> " + account.getClass().getName());
    }
}

 public class Discussion67{
    public static void main(String[] args) {
        System.out.println("saving account******");
        SavingsAccount saving = new SavingsAccount(25000.00);
        saving.showBalance();
        saving.deposit(4999.00);
        saving.withdraw(400.00);
        saving.showBalance();

        System.out.println("current account******");
        CurrentAccount current = new CurrentAccount(1200.00);
        current.showBalance();
        current.deposit(1200.00);
        current.withdraw(200.00);
        current.showBalance();

        System.out.println("bounded account *****");
        BankAccount<SavingsAccount> obj = new BankAccount<>(saving);
        obj.showAccaccount();

        BankAccount<CurrentAccount> cu = new BankAccount<>(current);
        cu.showAccaccount();
    }
 }