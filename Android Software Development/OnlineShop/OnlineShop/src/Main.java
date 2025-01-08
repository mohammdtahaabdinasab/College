import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String productName[] = new String[3];
        int productId[] = new int[3];

        System.out.println("- - - - - - - - - Register Your Products - - - - - - - - -");

        Scanner inputProductName = new Scanner(System.in);
        Scanner inputProductId = new Scanner(System.in);
        Scanner inputManageSystem = new Scanner(System.in);

        for (int i = 0; i < (productName.length-1) ; i++) {
            System.out.print("Enter you product name: ");
            productName[i] = inputProductName.nextLine();
            System.out.print("Enter your product id: ");
            productId[i] = inputProductId.nextInt();
        }

        System.out.println("- - - - - - - - - Welcome To Manage System - - - - - - - - -");

        boolean systemStatus = true;
        int checkSeachIndex;

        while (systemStatus){
            System.out.print("Enter Product ID : ");
            int manageSystemProductId = inputManageSystem.nextInt();
            checkSeachIndex = productId.length;
            for (int i = 0; i <= (productId.length-1) ; i++) {
                if (manageSystemProductId == 0){
                    System.out.println("- - - - - - - - - We get exit code, Good Bye - - - - - - - - -");
                    systemStatus = false;
                    break;
                }
                else if (manageSystemProductId == productId[i]){
                    if (productName[i].equalsIgnoreCase("laptop")){
                        System.out.println("We don't have this product");
                        break;
                    }
                    else {
                        System.out.println("We Find One Prodocut, Your Product Is "+productName[i]);
                        break;
                    }
                }
                checkSeachIndex--;
                if (checkSeachIndex == 0){
                    System.out.println("This Project Not Found");
                    systemStatus = false;
                    break;
                }
            }
        }

    }
}