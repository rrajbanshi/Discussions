/*
 Write a Java program to do the following.

Create an interface called Notification as follows:

interface Notification {
    void notifyUser();
}
Implement the Notification interface in two classes named SMSNotification and EmailNotification. Override the abstract method(s) of the interface in these concrete classes and print the messages "Sending an SMS notification" and "Sending an e-mail notification" respectively.

Create a driver class called PolymorphicReferenceDemo. The driver class will contain the main() method. Inside the main() method, define an object reference of type Notification as follows:

Notification notification;
Then, do the following:

Create an object of the SMSNotification class and assign it to the notification reference variable. Use the reference to call the notifyUser() method.
Create an object of the EmailNotification class and assign it to the notification reference variable. Use the reference to call the notifyUser() method.
 */

 import java.util.*;

 interface Notification{
    void notifyUser();
 }

 class SMSNotification implements Notification{
   @Override
  public void notifyUser(){
   System.out.println("SMS notification");
 }
 }

 class EmailNotification implements Notification{
    @Override
    public void notifyUser(){
        System.out.println("EMail Notification");
    }
 }
 public class Main69{
    public static void main(String[] args) {
        Notification sms = new SMSNotification();
        sms.notifyUser();

        Notification email = new EmailNotification();
        email.notifyUser();
    }
 }