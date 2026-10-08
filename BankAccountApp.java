import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Parameterized constructor
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited the amount: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew the amount: $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance, Withdrawal failed.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    
    public double checkBalance() {
        return balance;
    }

    
    public void displayAccount() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Current Balance: $" + balance);
        System.out.println("-----------------------");
    }
}

public class BankAccountApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read initial details from the user
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String holderName = scanner.nextLine();

        System.out.print("Enter Initial Balance: ");
        double initialBalance = scanner.nextDouble();

        
        BankAccount account = new BankAccount(accNum, holderName, initialBalance);

    
        System.out.print("\nEnter amount to deposit: ");
        double depositAmount = scanner.nextDouble();
        account.deposit(depositAmount);

    
        System.out.print("Enter amount to withdraw: ");
        double withdrawAmount = scanner.nextDouble();
        account.withdraw(withdrawAmount);

        
        System.out.println("\nChecked Balance: $" + account.checkBalance());

        
        account.displayAccount();

        scanner.close();
    }
}