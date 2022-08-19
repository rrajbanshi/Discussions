/*
 You are given the following blueprint for representing a college Student:

class Student {
    private String name;
    private int id;
    private String subject;

    double percentage;

    public Student(String name, int id, String subject, double percentage) {
        this.name = name;
        this.id = id;
        this.subject = subject;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public double getPercentage() {
        return percentage;
    }

    @Override
    public String toString() {
        return name + "-" + id + "-" + subject + "-" + percentage;
    }
}
Create four Student instances:

Student student1 = new Student("Dinesh", 1, "Algorithms", 75);
Student student2 = new Student("Arnav", 2, "Automata", 55);
Student student3 = new Student("Anamika", 3, "Databases", 80);
Student student4 = new Student("Vishal", 4, "Networking", 40);
Create a list of these students called studentList and do the following operations:

Partition the students who got above 60% from those who didn’t.
Get the names of the top 3 performing students.
Get the name and percentage of each student.
Get the set of subjects offered in the college
Get the highest, the lowest, and the average percentage of students
Get the total number of students from the given list of students
Get the students grouped by subject from the given list of students
Expected Output:

{false=[Arnav-2-Automata-55.0, Vishal-4-Networking-40.0], true=[Dinesh-1-Algorithms-75.0, Anamika-3-Databases-80.0]}

[Anamika-3-Databases-80.0, Dinesh-1-Algorithms-75.0, Arnav-2-Automata-55.0]

{Anamika=80.0, Dinesh=75.0, Arnav=55.0, Vishal=40.0}

[Algorithms, Databases, Networking, Automata]

Highest Percentage: 80.0
Lowest Percentage: 40.0
Average Percentage: 62.5

4

{Databases=[Anamika-3-Databases-80.0], Algorithms=[Dinesh-1-Algorithms-75.0], Networking=[Vishal-4-Networking-40.0], Automata=[Arna
 */



 import java.util.*;
import java.util.stream.Collectors;

 class Student {
    private String name;
    private int id;
    private String subject;

    double percentage;

    public Student(String name, int id, String subject, double percentage) {
        this.name = name;
        this.id = id;
        this.subject = subject;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public double getPercentage() {
        return percentage;
    }

    @Override
    public String toString() {
        return name + "-" + id + "-" + subject + "-" + percentage;
    }
}
 public class Discussion56{
    public static void main(String[] args) {
        Student student1 = new Student("Dinesh", 1, "Algorithms", 75);
        Student student2 = new Student("Arnav", 2, "Automata", 55);
        Student student3 = new Student("Anamika", 3, "Databases", 80);
        Student student4 = new Student("Vishal", 4, "Networking", 40);

        List<Student> studentList = Arrays.asList(student1, student2, student3, student4);

        studentList.stream().filter(x-> x.getPercentage() > 60).forEach(System.out::println);

       
        List<Student> topPerformer = studentList.stream()
                .sorted(Comparator.comparing(Student::getPercentage, Comparator.reverseOrder())).limit(3)
                .collect(Collectors.toList());
        System.out.println(topPerformer);

        Map<String, Double> nameNPercentage = studentList.stream().collect(Collectors.toMap(Student::getName, Student::getPercentage));
        System.out.println(nameNPercentage);

        List<String> subject = studentList.stream().map(x-> x.getSubject()).toList();
        System.out.println(subject);
        
        OptionalDouble top = studentList.stream().mapToDouble(Student::getPercentage).max();
        System.out.println("Highest percentage " + top.getAsDouble());

        OptionalDouble lowest = studentList.stream().mapToDouble(Student::getPercentage).min();
        System.out.println("Minimum percentage " + lowest.getAsDouble());

        OptionalDouble av = studentList.stream().mapToDouble(Student::getPercentage).average();
        System.out.println("average percentage " + av.getAsDouble());

        System.out.println("Total students: " + studentList.size());

        Map<String, List<Student>> groupBySubject = studentList.stream()
                .collect(Collectors.groupingBy(Student::getSubject));
        System.out.println(groupBySubject);
    }
 }