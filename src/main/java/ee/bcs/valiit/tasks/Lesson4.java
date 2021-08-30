package ee.bcs.valiit.tasks;

import java.util.HashMap;
import java.util.Scanner;

public class Lesson4 {
    // Store account nr as a key and account balance as value
    // HashMap<String, Double> accountBalanceMap = new HashMap<>(); double, integer jne numbri salvesti teisel kohal

    public static void main(String[] args) {
        HashMap<String, Double> accountBalanceMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        while (true){
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("exit")){
                break;
            }
            // TODO 1
            // Add command: "createAccount ${accountNr}"
            // this has to store accountNr with 0 balance
            else if (line.equalsIgnoreCase("createAccount")){
                System.out.println("Sisesta konto number");
                String accountNumber = scanner.nextLine();
                accountBalanceMap.put(accountNumber, 0.0);
            }
            // TODO 2
            // Add command: "getBalance ${accountNr}"
            // this has to display account balance of specific acount
            else if (line.equalsIgnoreCase("getBalance")){
                System.out.println("Sisesta saldo");
                String balance = scanner.nextLine();
                accountBalanceMap.put(balance, 0.0);
            }
            // TODO 3
            // Add command: "depositMoney ${accountNr} ${amount}
            // this has to add specified amount of money to account
            // You have to check that amount is positive number
             /*else if (line.equalsIgnoreCase("depositMoney")){
                System.out.println("Lisa summa");
                Double amountToAdd = scanner.nextDouble();
                Double balance = accountBalanceMap.get(accountNumber);
                Double newBalance = balance + amountToAdd;
                accountBalanceMap.put(accountNumber, newBalance); */

            // TODO 4
            // Add command: "withdrawMoney ${accountNr} ${amount}
            // This has to remove specified amount of money from account
            // You have to check that amount is positive number
            // You may not allow this transaction if account balance would become negative

            // TODO 5
            // Add command: "transfer ${fromAccount} ${toAccount} ${amount}
            // This has to remove specified amount from fromAccount and add it to toAccount
            // Your application needs to check that toAccount is positive
            // And from account has enough money to do that transaction

            else {
                System.out.println("Unknown command");
            }
        }
    }
}
