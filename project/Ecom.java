/*
 Ecommerce Application with Products, Users and Order History: Design the backend of an e-commerce application
  with Product, User, and Order classes. You need to use these three classes in tandem to implement the features
   of a user placing an order with multiple products. You can create the Product class with the productId,
    productName, quantity, and unitPrice. The order will have the details such as the Product, shippedDate,
     orderDate, userId, Address, phoneNumber, paymentMode. The User class will have details such as userId, 
     firstName, lastName, and savedAddresses. You need to implement the feature of placing orders by the user
      where the order has to contain 1 or more products.
 */

import java.util.*;
class Product{
    int productId;
    String productName;
    double quantity;
    double unitPrice;
    public int getProductId() {
        return productId;
    }
    public String getProductName() {
        return productName;
    }
    public double getQuantity() {
        return quantity;
    }
    public double getUnitPrice() {
        return unitPrice;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    public Product(int productId, String productName, double quantity, double unitPrice) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
}
//class order
class Order{
     String product;
     Date shippedDate;
     Date orderDate;
     int userId;
     String Address;
     String phoneNumber;
     String paymentMode;
    public String getProduct() {
        return product;
    }
    public Date getShippedDate() {
        return shippedDate;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public int getUserId() {
        return userId;
    }
    public String getAddress() {
        return Address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getPaymentMode() {
        return paymentMode;
    }
    public void setProduct(String product) {
        this.product = product;
    }
    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

}
//class User
 class User{
//userId,firstName, lastName, and savedAddresses
    int userId;
    String firstName;
    String lastName;
    String savedAddresses;

    public int getUserId() {
        return userId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getSavedAddresses() {
        return savedAddresses;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setSavedAddresses(String savedAddresses) {
        this.savedAddresses = savedAddresses;
    }
}



public class Ecom{
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product p1 = new Product(1, "shampoo",1, 200);
        Product p2 = new Product(2, "shocks",1, 100);
        Product p3 = new Product(3, "shoes",1, 1000);
        Product p4 = new Product(4, "jeans",1, 1500);
        Product p5 = new Product(5, "shirts",1, 2000);
        User user = new User();
        Order oder = new Order();
        List<Product> userArray = new LinkedList<>();    //for storing items 
        HashMap<Integer, Product> map = new HashMap<>();
        map.put(1, p1);
        map.put(2, p2);
        map.put(3, p3);
        map.put(4, p4);
        map.put(5, p5);

        String choice;
        System.out.println("*************************************************");
    choice = "Y";
    while(choice.equalsIgnoreCase("y")){
        for(int key : map.keySet()){
            Product values = map.get(key);
            String res = "Name: "+values.getProductName() + " Quantity: "+values.getQuantity() + " Price : " + values.getUnitPrice();
            System.out.println(key + ") " + res);
         }
        double res = 0;
        System.out.println("how many product you want:");
        int n = sc.nextInt();
        for(int i = 0;i < n;i++){
            System.out.println("enter productid");
            int option = sc.nextInt();
            Product ob = map.get(option);
            userArray.add(ob);
            System.out.println("Enter the quantity:");
            double quantity = sc.nextDouble();
              res += quantity * ob.getUnitPrice();
            System.out.println(res);  
          }  
          System.out.println("Do you want to order:>enter 1/0 for [y/n]");
         int order = Integer.parseInt(sc.next());
         if(order == 1){
            sc.nextLine();
            System.out.println("Enter your FirstName:");
            String first = sc.nextLine();
            user.setFirstName(first);
            System.out.println("Enter your LastName:");
            String last = sc.nextLine();
            user.setLastName(last);
            System.out.println("Enter Address");
            String add = sc.nextLine();
            user.setSavedAddresses(add);
            System.out.println("Enter user id");
            int userid = sc.nextInt();
            user.setUserId(userid);

            Date date = new Date();
            oder.setOrderDate(date);
            oder.setShippedDate(date);
            oder.setAddress(user.getSavedAddresses());
            oder.setUserId(user.getUserId());
            sc.nextLine();
            System.out.println("Enter your phone number:");
             String numberP = sc.nextLine();
            oder.setPhoneNumber(numberP);
            System.out.println("Enter the payment method/ 1. google pay, 2. phonepay");
            String payment = sc.next();
            oder.setPaymentMode(payment);

           System.out.println("***************ordered********************");
           System.out.println("UserId " + oder.getUserId());
           System.out.println("name: " + user.getFirstName() + " " + user.getLastName());
           System.out.println("Address: " + oder.getAddress());
           System.out.println("phone " + oder.getPhoneNumber());
           System.out.println("*****product details**********");
           for(Product pr : userArray){
            System.out.println("id " + pr.getProductId() + " name " + pr.getProductName() + " quantity " + pr.getQuantity() + " price " + pr.getUnitPrice());
            
           }
           System.out.println("total cost ="+res);
   
         }
         
          System.out.println("Do you want to Continue [press [Y] to continue::");
          choice = sc.next();
          if(!choice.equalsIgnoreCase("y")) {
        	  System.out.println("Thank you for shopping:");
          }
    }
}

}