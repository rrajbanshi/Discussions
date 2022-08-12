/*
 Like a class, an interface can have methods and variables, but the methods declared in the interface are by default abstract (only method signature, no method body).

Given an interface in1 which includes a method display that takes an integer as input.

interface in1
{
    void display(int p);
}
The task is to write a class TestClass which implements interface in1 and has a method display() that takes an integer as input and prints the total number of prime numbers between 2 and integer k (including it).

Input:
The first line will contain an integer T (number of test cases). Each test case consists of an integer n.

Output:
Print total number of prime numbers between 2 and the given number ( including them ).

Example:

Input:
2
13
19

Output:
6
8
 */

import java.util.*;
interface in1{
    void display(int p);
}

class TestClass implements in1{
    
    private static boolean isPrime(int n) {
        if (n < 2)
            return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }

        }
        return true;
    }
    @Override
    public void display(int p){
        int count = 0;
        for(int i = 2; i <= p; i++){
            if(isPrime(i)){
                count++;
            }
        }
        System.out.println(count);
    }
}

 public class PrimeInRange{
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter the number of testcase");
       int n = Integer.parseInt(sc.nextLine()); 
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
        arr[i] = sc.nextInt();
    }
    int l = 0;
    while(n-- > 0){
        TestClass test = new TestClass();
        test.display(arr[l]);
        l++;
    }
    }
 }