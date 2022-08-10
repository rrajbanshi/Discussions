
/*WAP to find the LCM of two numbers. */

import java.util.*;
public class Lcm{

    public static int evaluateGcd(int a, int b){
        while( a % b != 0){
            int rem = a % b;
            a = b;
            b = rem;
        }
        return b;
    }
    public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      int num1 = Integer.parseInt(sc.nextLine());
      int num2 = Integer.parseInt(sc.nextLine());
      int gcd = evaluateGcd(num1, num2);
      int lcm = (num1 * num2) / gcd;
      System.out.println(lcm);
    }
}