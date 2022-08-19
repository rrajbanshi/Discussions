/*
 Define a class called Book. The skeleton of the Book class is given below:

class Book implements Comparable<Book> {
    int id;
    String name;
    String author;
    String publisher;
    int quantity;

    // parameterised constructor

    // override toString()

    // override hashCode()

    // override equals()

    // override compareTo(Book other): compares by id
}
Write the implementation for hashCode() and equals() manually. (Important fields: id)

In the driver class called BookMarket, create four instances of the Book class with the following:

Book b1 = new Book(121, "Let us C", "Yashwant Kanetkar", "BPB", 8);
Book b2 = new Book(233, "Operating System", "Galvin", "Wiley", 6);
Book b3 = new Book(101, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
Book b4 = new Book(121, "Let us C", "Yashwant Kanetkar", "Mc Graw Hill", 11);
Create an ArrayList<Book> called books and insert the above book objects.

Use Stream API to do the following operations:

Print the details of each book in the given list of books.
Create a Set of books from the List by using a collector method, and then print the set.
Sort the List of books using the intermediate operation sorted(). Display the sorted results.
Double the quantity of each book in the List using the intermediate operation map(), and then display the updated books.
Use the intermediate operation filter() to keep only those books that quantity > 10 and collect them in a list, and print them.
Use the terminal operation reduce() to obtain the sum of quantity sold of books that have id < 200, and then print the sum obtained.
 */

import java.util.*;
import java.util.stream.Collectors;

class Book implements Comparable<Book> {
    int id;
    String name;
    String author;
    String publisher;
    int quantity;
    
    public Book(int id, String name, String author, String publisher, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getAuthor() {
        return author;
    }
    public String getPublisher() {
        return publisher;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
        result = prime * result + quantity;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (author == null) {
            if (other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (publisher == null) {
            if (other.publisher != null)
                return false;
        } else if (!publisher.equals(other.publisher))
            return false;
        if (quantity != other.quantity)
            return false;
        return true;
    }
    @Override
    public int compareTo(Book o) {
        return this.id - o.id;
    }
    @Override
    public String toString() {
        return "Book [author=" + author + ", id=" + id + ", name=" + name + ", publisher=" + publisher + ", quantity="
                + quantity + "]";
    }
    
}

public class Discussion53{
    public static void main(String[] args) {
        Book b1 = new Book(121, "Let us C", "Yashwant Kanetkar", "BPB", 8);
        Book b2 = new Book(233, "Operating System", "Galvin", "Wiley", 6);
        Book b3 = new Book(101, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
        Book b4 = new Book(121, "Let us C", "Yashwant Kanetkar", "Mc Graw Hill", 11);

        ArrayList<Book> books = new ArrayList<>();
        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);

        System.out.println("Printing using streams");
        books.stream().forEach(System.out::println);

        System.out.println("storing in set");
        Set<Book> setOfBook = books.stream().collect(Collectors.toSet());
        setOfBook.stream().forEach(System.out::println);
      
        System.out.println("Sorted the List of books using the intermediate operation sorted()");
        books.stream().sorted().forEach(System.out::println);
        
        System.out.println("Double the quantity of each book in the List using the intermediate operation map()");
        List<Book> booklist = books.stream().sorted().map(o->{
            o.quantity = o.quantity * 2;
            return o;
        }).toList();
        booklist.stream().forEach(System.out::println);

        System.out.println("quantity > 10");
        List<Book> Quant = books.stream().filter(x -> x.quantity > 10).toList();
        Quant.stream().forEach(System.out::println);


        System.out.println("sold of books that have id < 200");
        int soldBooks = books.stream().filter(o -> o.id < 200).map(o -> o.quantity).reduce(0, (ans, q) -> ans + q);
        System.out.println("quantity sold of books having id < 200 is " + soldBooks);
    }
}