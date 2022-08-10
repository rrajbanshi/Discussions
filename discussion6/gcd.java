
/*WAP to find the GCD (or HCF) of two numbers. */

import java.util.*;
public class gcd{

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
      int res = evaluateGcd(num1, num2);
      System.out.println(res);
    }
}