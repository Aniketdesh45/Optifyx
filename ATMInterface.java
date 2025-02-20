import java.util.ArrayList;
import java.util.Scanner;

class ATM {
    private double balance;
    private ArrayList<String> transactionHistory;
    private int userPin=123; // Hardcoded PIN for demo

    public ATM(double initialBalance) {
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public boolean authenticate(int pin) {
        return pin == userPin;
    }

    public void viewBalance() {
        System.out.println("Your Current Balance is: " + balance);
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawn: " + amount);
            System.out.println("Collect the Cash: " + amount);
        } else {
            System.out.println("Invalid Withdrawal Amount or Insufficient Balance.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount);
            System.out.println("Successfully Deposited: " + amount);
        } else {
            System.out.println("Invalid Deposit Amount.");
        }
    }

    public void viewTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(10000.0); // Initial balance

        System.out.print("Enter ATM PIN: ");
        int pin = scanner.nextInt();

        if (!atm.authenticate(pin)) {
            
			System.out.println("Incorrect PIN ...😔");
			System.out.println("Please Enter Valid PIN 😇");
			
            return;
        }

        System.out.println("Account Authorized!");
        while (true) {
            System.out.println("\n1. View Available Balance");
            System.out.println("2. Withdraw Amount");
            System.out.println("3. Deposit Amount");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.viewBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 4:
                    atm.viewTransactionHistory();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid Choice. Try Again.");
            }
        }
    }
}