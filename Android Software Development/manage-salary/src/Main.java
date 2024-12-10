import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for (int i = 1; i <= 10; i++) {
            System.out.print("\n"+"please enter your name : ");
            String name = input.nextLine();
            System.out.print("\n"+name+" please enter your salary : ");
            double salary = Double.parseDouble(input.nextLine());
            if (salary >= 20000) {
                salary -= (salary * 0.1825);
                System.out.println("\n"+name+" your salary is : "+salary+" After salary deficit (18%)");
            }
            else if (salary >= 10000) {
                salary -= (salary * 0.175);
                System.out.println("\n"+name+" your salary is : "+salary+" After salary deficit (17%)");
            }
            else if (salary <= 7500) {
                salary += (salary * 0.175);
                System.out.println("\n"+name+" your salary is : "+salary+" After salary increase (17%)");
            }
            salary += (salary * 0.035);
            System.out.println("\n"+name+" your salary is : "+salary+" Additional salary for children (3.5%)");
            System.out.println("----------------------------------------------------------------------------------");
        }
    }
}