public class BankAccount {
    // Private fields to store account details
    private String accountNumber;
    private double balance;

    // Constructor to initialize the bank account
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Public method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Public method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    // Public method to get the current balance
    public double getBalance() {
        return balance;
    }

    // Public method to get the account number (optional)
    public String getAccountNumber() {
        return accountNumber;
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Create a new bank account
        BankAccount account = new BankAccount("123456789", 1000.00);

        // Perform some operations
        account.deposit(500.00);
        account.withdraw(200.00);
        account.withdraw(1500.00); // Attempt to withdraw more than the balance

        // Print the current balance
        System.out.println("Current balance: $" + account.getBalance());
    }
}