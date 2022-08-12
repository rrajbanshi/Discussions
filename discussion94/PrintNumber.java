/*Create a class named 'PrintNumber' to print various numbers of different datatypes by creating different
methods with the same name 'printn' having a parameter for each datatype */

import java.util.*;
public class PrintNumber{
    public  void printn(int n){
        System.out.println("Integer " + n + "");
    } 

    public void printn(String n){
        System.out.println("String " + n + "");
    }

    public void printn(float f){
        System.out.println("Float " + f + "");
        }
    public void printn(double d){
        System.out.println("Double " + d + "");
        }
        public void printn(boolean b){  
            System.out.println("Boolean " + b + "");
        }
        public void printn(char c){ 
            System.out.println("char " + c + "");
            }
    public static void main(String[] args) {
        PrintNumber obj = new PrintNumber();
        obj.printn(1);
        obj.printn(2.9);
        obj.printn(true);
        obj.printn("Rakesh");
        obj.printn('c');
        obj.printn(2.34f);

    }
}

