/*
 Create a menu-driven calculator which performs the following arithmetic operations on two user-input numbers:

Addition
Subtraction
Multiplication
Division
Quit
The program should ask the user whether they want to continue or not after every calculation.
 */



import java.util.*;

public class menuDriven {
public static void main(String args[]) {

    Scanner sc = new Scanner(System.in);
    String choice;

    loop:do{
        choice = "";
        System.out.println("enter the value of a");
        int a = Integer.parseInt(sc.nextLine());
        System.out.println("enter the value of b");
        int b = Integer.parseInt(sc.nextLine());

        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. multiplication");
        System.out.println("4. Division");
        System.out.println("5. quit");

        System.out.print("Enter Choice from 1 to 5->:");

        int option = Integer.parseInt(sc.nextLine());
        switch (option){
            case 1:
             System.out.println("sum is :"+ (a+b));
             System.out.println("Do you want to continue? [Y/N]");
             choice = sc.nextLine();
               break;
               
            case 2:
            System.out.println("Sub is :"+ (a - b ));
            System.out.println("Do you want to continue? [Y/N]");
            choice = sc.nextLine();
               break;

            case 3:
              System.out.println("mul is" + (a * b) );
              System.out.println("Do you want to continue? [Y/N]");
              choice = sc.nextLine();
              break;

            case 4:
            if(b == 0){
                System.out.println("divide by zero");
              }
             System.out.println("Div is :" + ( a / b ));
             System.out.println("Do you want to continue? [Y/N]");
             choice = sc.nextLine();
              break;

            case 5:
              break loop; 

            default :
              System.out.println("Unknown Entry");
              choice = "Y";
              break;  
            } 
    
    } while (choice.equalsIgnoreCase("Y"));
    if(choice.equalsIgnoreCase("N")){
        System.out.println("You have pressed 'N', program exited !!");
    }
    sc.close();
}

}