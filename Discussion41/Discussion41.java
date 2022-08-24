/*
 WAP to print the even and odd numbers to a value LIMIT using two threads.

Hint - You can use a static variable, a non-static counter, two functions (one for printing even numbers, one for printing odd numbers), the synchronized block, and the notifyAll() method.
 */

 import java.util.*;

 interface maxLimit{
    int max = 10;
 }

 class EvenThread extends Thread implements maxLimit{
    @Override
    public void run(){
        for(int i = 0; i < max; i++){
            if(i % 2 == 0){
                System.out.println("Even number");
            }
        }
    }
 }

 class OddThread extends Thread implements maxLimit{
    @Override
    public void run(){
        for(int i = 0; i < max; i++){
            if(i %  2 != 0){
                System.out.println("Odd number");
            }
        }
    }
 }
 public class Discussion41{
    public static void main(String[] args) {
        EvenThread t1 = new EvenThread();
        OddThread t2 = new OddThread();
        t1.start();
        t2.start();
    }
 }