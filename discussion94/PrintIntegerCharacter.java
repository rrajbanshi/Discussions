/* 
Create a class to print an integer and a character with two methods having the same name but a different sequence of the integer and the character parameters.
For example, if the parameters of the first method are of the form (int n, char c), then that of the second method will be of the form (char c, int n).
 */
class Numbers{
    public void printValues(int n, char c){
     System.out.println(n+" "+c);
    }
    public void printValues(char c, int n){
     System.out.println(c+" "+n);
    }
}
public class PrintIntegerCharacter {
    public static void main(String[] args) {
         Numbers obj = new Numbers();
        obj.printValues(1, 'c');
        obj.printValues('c', 5);
    }
}
