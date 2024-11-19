import java.util.Scanner;

public class Main
{
    public static  void main(String[] args)
    {
        System.out.println("Hello, Welcome to my application :D");
        System.out.println("This software calculates the financial rights of workers!");
        Scanner myScannerObject = new Scanner(System.in);
        for (int i = 1; i <= 10; i++)
        {
            System.out.print("Enter your name worker "+i+" : ");
            String name = myScannerObject.nextLine();

            if (name.equalsIgnoreCase("exit"))
            {
                break;
            }

            try
            {
                System.out.print(name+" enter your salary : ");
                int salary = Integer.parseInt(myScannerObject.nextLine());
                if (salary >= 5700) {
                    salary -= (salary * 5 / 100);
                }
                try {
                    System.out.print(name+" enter the number of your children : ");
                    int children = Integer.parseInt(myScannerObject.nextLine());
                    for (int j = 1; j < children; j++) {
                        salary += (salary * 7 / 100);
                    }

                }
                catch (NumberFormatException e) {
                    System.out.println("you must enter a number");
                    break;
                }

                System.out.println(name+" your salary is : "+salary);
            }
            catch (NumberFormatException e)
            {
                System.out.println("you must enter a valid salary");
                break;
            }
        }
        System.out.print("my mission is complete, goodbye!");
        myScannerObject.close();
    }
}
