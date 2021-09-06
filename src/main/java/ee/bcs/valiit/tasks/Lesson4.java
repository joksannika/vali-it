package ee.bcs.valiit.tasks;

import java.util.HashMap;
import java.util.Scanner;

public class Lesson4 {
    // Store account nr as a key and account balance as value
    // HashMap<String, Double> accountBalanceMap = new HashMap<>(); double, integer jne numbri salvesti teisel kohal

    public static void main(String[] args) {
        HashMap<String, Double> accountBalanceMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vali tegevus:\n" +
                "createaccount\n" +
                "getbalance\n" +
                "depositmoney\n" +
                "withdrawmoney\n" +
                "transfer\n" +
                "exit");
        System.out.println("");
        while (true) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("exit")) {
                break;
            }
            // TODO 1
            // Add command: "createAccount ${accountNr}"
            // this has to store accountNr with 0 balance
            else if (line.equalsIgnoreCase("createAccount")) {
                System.out.println("Sisesta konto nr");
                String accountNr = scanner.nextLine();
                accountBalanceMap.put(accountNr, 0.0);
               // System.out.println("Konto " + (accountNr) + " loodud");
               // System.out.println(accountBalanceMap.containsKey(accountNr));
                System.out.println("Loodud konto: " + accountBalanceMap.keySet());
            }
            // TODO 2
            // Add command: "getBalance ${accountNr}"
            // this has to display account balance of specific account
            else if (line.equalsIgnoreCase("getBalance")) {
                System.out.println("Vali konto ");
                String accountNr = scanner.nextLine();
                System.out.println(accountBalanceMap.get(accountNr));
            }
            // TODO 3
            // Add command: "depositMoney ${accountNr} ${amount}
            // this has to add specified amount of money to account
            // You have to check that amount is positive number
            else if (line.equalsIgnoreCase("depositMoney")) {
                System.out.println("Vali konto");
                String accountNr = scanner.nextLine();
                System.out.println("Sisesta summa");
                int amount = scanner.nextInt();
                scanner.nextLine();
                if (amount >= 0) {
                    accountBalanceMap.put(accountNr, accountBalanceMap.get(accountNr) + amount);
                    System.out.println("Summa " + amount + " sisestatud. Uus saldo: " + accountBalanceMap.get(accountNr));
                }
            }
            // TODO 4
            // Add command: "withdrawMoney ${accountNr} ${amount}
            // This has to remove specified amount of money from account
            // You have to check that amount is positive number
            // You may not allow this transaction if account balance would become negative
            else if (line.equalsIgnoreCase("withdrawMoney")) {
                System.out.println("Vali konto");
                String accountNr = scanner.nextLine();
                System.out.println("Sisesta välja võetav summa");
                int amount = scanner.nextInt();
                scanner.nextLine();
                if (amount >= 0 && (accountBalanceMap.get(accountNr) - amount) >= 0) {
                    accountBalanceMap.put(accountNr, accountBalanceMap.get(accountNr) - amount);
                    System.out.println("Summa " + amount + " eemaldatud. Uus saldo: " + accountBalanceMap.get(accountNr));
                } else {
                    System.out.println("Tehingut ei toimunud.");
                }
                // TODO 5
                // Add command: "transfer ${fromAccount} ${toAccount} ${amount}
                // This has to remove specified amount from fromAccount and add it to toAccount
                // Your application needs to check that toAccount is positive
                // And from account has enough money to do that transaction
            } else if (line.equalsIgnoreCase("transfer")) {
                System.out.println("Vali konto kust soovid raha saata");
                String fromAccount = scanner.nextLine();
                System.out.println("Sisesta summa");
                int amount = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Vali konto kuhu summa lisada");
                String toAccount = scanner.nextLine();
                if (amount >= 0 && (accountBalanceMap.get(fromAccount) -
                        amount) >= 0 && accountBalanceMap.containsKey(fromAccount) &&
                        accountBalanceMap.containsKey(toAccount)) {
                    accountBalanceMap.put(fromAccount, accountBalanceMap.get(fromAccount) - amount);
                    accountBalanceMap.put(toAccount, accountBalanceMap.get(toAccount) + amount);
                    System.out.println("Summa " + amount + " eemaldatud. Uus saldo: " + accountBalanceMap.get(fromAccount));
                    System.out.println("Summa " + amount + " lisatud. Uus saldo: " + accountBalanceMap.get(toAccount));
                }
            } else {
                System.out.println("Unknown command");
            }
        }
    }
}

