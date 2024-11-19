import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Welcome to my application :D");
        System.out.println("This application get 10 names and counts letters of names for you!");
        Scanner myScannerObject = new Scanner(System.in);
        for (int i = 1; i <= 10; i++) {
            System.out.print("Enter Name "+i+" : ");
            String Name = myScannerObject.nextLine();
            if (Name.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println("Your name is "+Name+" and length your name is "+Name.length());
        }
        System.out.print("my mission is complete, goodbye!");
    }
}