package org.example;

import org.example.Interface.AtmOperations;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int atmPin = 1234;
        int atmNumber = 12345;
        boolean transaction =false;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ATM Number: ");
        int atmNumberInput = scanner.nextInt();
        System.out.println("Enter ATM Pin: ");
        int atmPinInput = scanner.nextInt();

        if(atmNumberInput == atmNumber && atmPinInput == atmPin) {
            System.out.println("ATM Pin and ATM Number are correct");
            transaction=true;
            AtmOperations atmOperations = new AtmOperationImpl();
            while(transaction==true){
            System.out.println("Enter the choice");
            System.out.println("1. Check Balance \n2. Deposit \n3. Withdraw \n4. Exit");
            int choice = scanner.nextInt();


                switch (choice) {
                    case 1:
                        atmOperations.checkBalance();
                        break;
                    case 2:
                        System.out.println("Enter the amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        System.out.println("Enter the number of 2000 notes: ");
                        int twoThousandNotes = scanner.nextInt();
                        System.out.println("Enter the number of 500 notes: ");
                        int fiveHundredNotes = scanner.nextInt();
                        System.out.println("Enter the number of 100 notes: ");
                        int oneHundredNotes = scanner.nextInt();
                        atmOperations.deposit(depositAmount,twoThousandNotes,fiveHundredNotes,oneHundredNotes);
                        break;
                    case 3:
                        System.out.println("Enter the amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        atmOperations.withdraw(withdrawAmount);
                        break;
                    case 4:
                        transaction=false;
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice");
                }
            }



        } else {
            System.out.println("ATM Pin and ATM Number are incorrect");
        }
    }
}
