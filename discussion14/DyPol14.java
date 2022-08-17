/*
 PART - 1:

WAP to declare a class BankAccount.
BankAccount: accNo, accHolderName, accBalance.
Extend BankAccount class in SavingsAccount and CurrentAccount class.
SavingsAccount: rateOfInterest, getYearlyInterest(), getComputedInterest(years).
CurrentAccount: avgDailyTransaction, getYearlyTransaction(), getTotalTransactionAmount(days)
Include the accessor and mutator functions in all the classes.
Override toString() in all the classes.
Create a driver class and create objects of BankAccount, SavingsAccount, CurrentAccount classes called generalAcc, savingsAcc, and currentAcc respectively. and demonstrate all the functions.
Create an anonymous inner class for SalaryAccount and instantiate it to a reference called salaryAcc, and demonstrate the working of all the methods.
SalaryAccount: salary (monthly), pfDeduction (monthly), incomeTaxRate, getYearlyTax(), getYearlyInHandSalary().
PART - 2:

Take an integer 'n' as input from the user. Create 'n' objects of each of the aforementioned account types. (Hint - use an array of objects)
WAF that takes an object of an account type as input and returns a clone object (new object with copied values). The input object and the returned object should have identical states and should exist separately in the memory
 */

 import java.util.*;

 class BankAccount{
    int accNo;
    String accHolderName;
    double accBalance;
    public BankAccount(){
        this.accNo = 0;
        this.accBalance = 0.0;
        this.accHolderName = "";
    }
    public BankAccount(int accNo, String accName, double accBalance){
        this.accNo = accNo;
        this.accHolderName = accName;
        this.accBalance = accBalance;
    }

    public int getAccNo() {
        return accNo;
    }

    public String getAccHolderName() {
        return accHolderName;
    }

    public double getAccBalance() {
        return accBalance;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public void setAccHolderName(String accHolderName) {
        this.accHolderName = accHolderName;
    }

    public void setAccBalance(double accBalance) {
        this.accBalance = accBalance;
    }
    @Override
    public String toString() {
        return "BankAccount [accBalance=" + accBalance + ", accHolderName=" + accHolderName + ", accNo=" + accNo + "]";
    }

    
 }
class SavingsAccount extends BankAccount{
    // rateOfInterest, getYearlyInterest(), getComputedInterest(years)
    double rateOfInterest;
    SavingsAccount(){
        super();
        rateOfInterest = 0.0;
    }
    SavingsAccount(int accNo, String accHolder, double accBalance , double rateOfInterest){
        super(accNo, accHolder, accBalance);
        this.rateOfInterest = rateOfInterest;
    }

    public double getComputedInterest(int yr){
      double CI = super.accBalance * (Math.pow((1 + this.rateOfInterest / 100), yr)) ;
      return CI;
    }
    public double getYearlyInterest(){
        double yi = (accBalance * rateOfInterest * 1) / 100;
        return yi;
    }
    @Override
    public String toString() {
        return "SavingsAccount [ current account " + super.toString() + " rateOfInterest=" + rateOfInterest + "]";
    }
    
}
class CurrentAccount extends BankAccount{
    double avgDailyTransaction;
    public CurrentAccount(){
        super();
        avgDailyTransaction = 0;
    }

    public CurrentAccount(int accNo, String accName, double accBalance, double avgDailyTransaction){
        super(accNo, accName, accBalance);
        this.avgDailyTransaction = avgDailyTransaction;
    }

    public double getYearlyTransaction(){
          return getTotalTransactionAmount(365);
    }

    public double getTotalTransactionAmount(int days){
           return avgDailyTransaction * days;
    }
    @Override
    public String toString() {
        return "Current Account :-\n" + super.toString() + "avgDailyTransaction : " +
                this.avgDailyTransaction + "\n";
    }
}

 public class DyPol14{
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
     BankAccount generalAcc = new BankAccount(12345, "Normal Account", 1500);
     System.out.println("*****general account*******");
     System.out.println("name "+ generalAcc.getAccHolderName());
     System.out.println("Balance " + generalAcc.getAccBalance());
     System.out.println("account num " + generalAcc.getAccNo());
    
     SavingsAccount saving  = new SavingsAccount(43435, "savingAccount", 5000, 5);
     System.out.println("******saving account*******");
     System.out.println("Balance " +saving.getAccBalance());
     System.out.println("name "+saving.getAccHolderName());
     System.out.println("get yearly interest " + saving.getYearlyInterest());
     System.out.println("Enter the year to get Computed Interest");
     int yr = sc.nextInt();
     System.out.println("compund Interest -> " + saving.getComputedInterest(yr));
    
     System.out.println("*********current account**********");
     CurrentAccount currentAcc = new CurrentAccount(45454, "Current Account", 6000, 300);
     System.out.println("Balance " +currentAcc.getAccBalance());
     System.out.println("name "+currentAcc.getAccHolderName());
     System.out.println("account num " +currentAcc.getAccNo());
     System.out.println("Enter the num of days for total transaction");
     int days = sc.nextInt();
     System.out.println("get total amt " + currentAcc.getTotalTransactionAmount(days));
     System.out.println("get total transaction " + currentAcc.getTotalTransactionAmount(days));

     //anonymous class creation
     BankAccount salaryAcc = new BankAccount(54321, "salary Account", 5000){
          double salary = 20000;
          double pfDeduction = 1000;
          double incomeTaxRate = 8.5;
           
          

          double getYearlyTax() {
            return (salary * 12.0) * incomeTaxRate / 100;
        }
        double getYearlyInHandSalary(){
            double tax = salary * incomeTaxRate / 100;
            return (salary - tax - pfDeduction);
        }
         
        @Override
        public String toString(){
            return String.format("salary  %f %n Income tax rate %f %n yearly tax %f %n in hand salary %f" , salary,incomeTaxRate, getYearlyTax(), getYearlyInHandSalary());
        }
     };
     System.out.println("**anonymous class *****************");
     System.out.println(salaryAcc);
   }
 }