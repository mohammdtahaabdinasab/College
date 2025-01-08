import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String studentNames[] = new String[3];
        int studentScores[] = new int[3];
        int average=0;

        Scanner inputString = new Scanner(System.in);
        Scanner inputNumber = new Scanner(System.in);

        for (int i = 0; i <= (studentNames.length-1); i++) {
            System.out.print("\nHello, student "+(i+1)+" enter your name : ");
            studentNames[i] = inputString.nextLine();
            System.out.print("\n"+studentNames[i]+" enter your score : ");
            studentScores[i] = inputNumber.nextInt();
        }

        for (int i = 0; i <= (studentNames.length-1); i++) {
            System.out.println(studentNames[i]+"length letters of your name is "+studentNames[i].length());
        }

        for (int i = 0; i <= (studentScores.length-1); i++) {
            average += studentScores[i];
        }

        System.out.println(" - - - - - - Show Average of Scores- - - - - -");

        // average = average / studentNames.length;
        average /= studentScores.length;

        System.out.println("Show average student rates: "+average);

        System.out.println(" - - - - - - Show Scores Upper 17 - - - - - -");

        for (int i = 0; i <= (studentNames.length-1); i++) {
            if (studentScores[i] >= 17) {
                System.out.println(studentNames[i]+ " you have good score your score is "+studentScores[i]);
            }
        }

        System.out.println(" - - - - - - Show Scores lower 15 - - - - - -");

        for (int i = 0; i <= (studentNames.length-1); i++) {
            if (studentScores[i] <= 15) {
                System.out.println(studentNames[i]+ " you have bad score your score is "+studentScores[i]);
            }
        }

    }
}