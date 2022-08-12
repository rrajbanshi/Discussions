/*
 WAP to create an abstract class called Shape.

fields: name (GenericShape), area, perimeter
constructor
getters and setters
abstract function calculateArea()
abstract function calculatePerimeter()
abstract function draw() (draws the shape)
Extend the Shape class in Rectangle, Square, and Circle classes and provide an implementation for the abstract methods.
 */

abstract class Shape{
    String name;
    double area;
    double perimeter;

    public Shape(String name){
        this.name = name;
        this.area = 0;
        this.perimeter = 0;
    }
    public Shape(String name, double area, double perimeter){
        this.name = name;
        this.area = area;
        this.perimeter = perimeter;
    }

    public String getName() {
        return name;
    }
    public double getArea() {
        return area;
    }
    public double getPerimeter() {
        return perimeter;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setArea(double area) {
        this.area = area;
    }
    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }
  
    abstract double calculateArea();
    abstract double calculatePerimeter();
    abstract void draw();
}

class Rectangle extends Shape{
    int length, breadth;
    public Rectangle(String name, int length, int breadth){
        super(name);
        this.length = length;
        this.breadth = breadth;
    }
    public double calculateArea(){
      area = length * breadth;
      return area;
    }
    public double calculatePerimeter(){
        perimeter = 2 *(length + breadth);
        return perimeter;
    }
    public void draw(){
        System.out.println("for Rectangle");
        System.out.println("area " + calculateArea() + " perimeter :" + calculatePerimeter());
    }
}

class Square extends Shape{
    int length;
    public Square(String name, int length){
        super(name);
        this.length = length;
    }
    public double calculateArea(){
        area = length * length;
        return area;
    }

    public double calculatePerimeter(){
        perimeter = 4 * length;
        return perimeter;
    }

    public void draw(){
     System.out.println("for Square");
     System.out.println("area " + calculateArea() + " perimeter :" + calculatePerimeter());
    }
}

class Circle extends Shape{
    int radius;
    public Circle(String name, int radius){
        super(name);
        this.radius = radius;
    }
    public double calculateArea(){
        double pi = 3.14;
        area = pi * radius * radius;
        return area;

    }
    public double calculatePerimeter(){
        double pi = 3.14;
        perimeter = 2 * pi * radius;
        return perimeter;
    }
    public void draw(){
        System.out.println("for Circle");
        System.out.println("area " + calculateArea() + " perimeter :" + calculatePerimeter());
    }
}

 public class AbstractClass{
    public static void main(String[] args) {
        Shape obj1 = new Rectangle("RECTANGLE", 10, 12);
        Shape obj2 = new Circle("CIRCLE", 5);
        Shape obj3 = new Square("SQUARE", 8);
        obj1.draw();
        System.out.println("get only area-> " + obj1.calculateArea());
        obj2.draw();
        System.out.println("get only Perimeter-> " + obj2.calculatePerimeter());
        obj3.draw();
        System.out.println("get only name -> " + obj3.getName());
        System.out.println(obj3.getPerimeter());
    }
 }