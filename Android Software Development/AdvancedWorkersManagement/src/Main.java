import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] workersFirstName = new String[2];
        String[] workersLastName = new String[2];
        String[] workersRegisterDate = new String[2];
        String[] workersRole = new String[2];
        Double[] workersSalaries = new Double[2];


        for (int i = 0; i < 2; i++) {
            System.out.print("Worker "+i+" Complete the information that is asked of you.");
            System.out.print("\nYour First Name : ");
            workersFirstName[i] = input.nextLine();
            System.out.print("\nYour Last Name : ");
            workersLastName[i] = input.nextLine();
            System.out.print("\nYour Register Date (like : 2024/12/24) : ");
            workersRegisterDate[i] = input.nextLine();
            System.out.print("\nYour Role : ");
            workersRole[i] = input.nextLine();
            System.out.print("\nYour Salaries : (Like 7500)");
            workersSalaries[i] = input.nextDouble();
            System.out.println("Press one key to continue.");
            input.nextLine();
        }

        input.close();

        System.out.println("\nList of workers who were register in 1993 : ");
        for (int i = 0; i < 2; i++) {
            if (workersRegisterDate[i].startsWith("1993")) {
                System.out.println(workersFirstName[i] + " " + workersLastName[i] + "Register date : " + workersRegisterDate[i]);
            }
        }

        System.out.println("\nList of workers who were role IT or Finance : ");
        for (int i = 0; i < 2; i++) {
            if (workersRole[i].equalsIgnoreCase("it") || workersRole[i].equalsIgnoreCase("finance")) {
                System.out.println(workersFirstName[i] + " " + workersLastName[i] + " Role : " + workersRole[i]);
            }

        }

        System.out.println("\nList of workers with family kazemi :");
        for (int i = 0; i < 2; i++) {
            if (workersLastName[i].equalsIgnoreCase("kazemi")) {
                System.out.println(workersFirstName[i] + " " + workersLastName[i]);
            }

        }

        System.out.println("\nList of workers with salaries above 23,000 tomans :");
        for (int i = 0; i < 2; i++) {
            if (workersSalaries[i] > 23700) {
                System.out.println(workersFirstName[i]+" "+workersLastName[i]+" : "+workersSalaries[i]+" -> "+(workersSalaries[i] * 0.93));
            }
        }
    }
}
