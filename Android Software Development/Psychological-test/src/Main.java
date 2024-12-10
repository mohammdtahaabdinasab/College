import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for (int i = 1; i <= 10; i++) {
            System.out.print("\nEnter your firstname : ");
            String firstName = input.nextLine();
            System.out.print("\nEnter your lastname : ");
            String lastName = input.nextLine();
            System.out.print("\nEnter date of psychological test : ");
            String date = input.nextLine();
            System.out.print("\nEnter your doctor name : ");
            String doctorName = input.nextLine();
            System.out.print("\nAnswer the question with yes or no");
            int score = 100;
            String[] question = {
                "Are you thinking about suicide",
                "Are you alone most of the day",
                "Do you feel empty",
                "Don't you enjoy your life",
                "Do you think you have no friends"
            };
            for (int j = 0; j <= question.length - 1 ; j++) {
                System.out.print("\n"+question[j]+" ? (yes/no) :");
                String answer = input.nextLine();
                if (answer.equalsIgnoreCase("yes")) {
                    score -= 20;
                }
            }
            System.out.println("\nyour fullname is "+firstName+" "+lastName+" date of your psychological test "+date+" your doctor name is "+doctorName);
            if (score >= 70){
                System.out.print("\nyou have good mind");
            } else if (score <= 70 && score > 50) {
                System.out.print("you must talk about your problem with psychologist");
            }
            else if (score <= 50 && score > 30) {
                System.out.print("you must go to the doctor");
            }
            else if (score <= 30){
                System.out.print("you must go to the hospital");
            }
            else {
                System.out.print("i don't know what's happened");
            }
        }
        input.close();
    }
}
