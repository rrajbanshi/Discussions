/*
 Create a class 'Degree' having a method 'getDegree' that prints "I got a degree". It has two subclasses namely 'Undergraduate' and 'Postgraduate' each having a method with the same name that prints "I am an Undergraduate" and "I am a Postgraduate" respectively. Call the method by creating an object of each of the three classes.
 */

 class Degree{
    public void getDegree(){
        System.out.println("I got a Degree");
    }
 }
 class Undergraduate extends Degree{
    @Override
    public void getDegree(){
        System.out.println("I am an undergraduate");
    }
 }

 class Graduate extends Degree{
    @Override
    public void getDegree(){
        System.out.println("I am graduate");
    }
 }
public class Poly1{
    public static void main(String[] args) {
       Degree obj1 = new Degree();
       Degree obj2 = new Undergraduate();
       Degree obj3 = new Graduate();
       obj1.getDegree();
       obj2.getDegree();
       obj3.getDegree(); 
    }
}
