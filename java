import java.util.ArrayList;
import java.util.Scanner;

class Transaction {
    String type;
    double amount;
    String description;

    public Transaction(String type, double amount, String description) {
        this.type = type;
        this.amount = amount;
        this.description = description;
    }
}

public class FinancialManagement {
    static ArrayList<Transaction> transactions = new ArrayList<>();
    static double balance = 0;
    static double budget = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Financial Management System");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Set Budget");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    addIncome(scanner);
                    break;
                case 2:
                    addExpense(scanner);
                    break;
                case 3:
                    viewBalance();
                    break;
                case 4:
                    viewTransactionHistory();
                    break;
                case 5:
                    setBudget(scanner);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    static void addIncome(Scanner scanner) {
        System.out.print("Enter income amount: ");
        double amount = scanner.nextDouble();
        System.out.print("Enter income description: ");
        String description = scanner.next();

        transactions.add(new Transaction("Income", amount, description));
        balance += amount;

        System.out.println("Income added successfully.");
    }

    static void addExpense(Scanner scanner) {
        System.out.print("Enter expense amount: ");
        double amount = scanner.nextDouble();
        System.out.print("Enter expense description: ");
        String description = scanner.next();

        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            transactions.add(new Transaction("Expense", amount, description));
            balance -= amount;

            System.out.println("Expense added successfully.");
        }
    }

    static void viewBalance() {
        System.out.println("Current Balance: " + balance);
    }

    static void viewTransactionHistory() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction.type + ": " + transaction.amount + " - " + transaction.description);
        }
    }

    static void setBudget(Scanner scanner) {
        System.out.print("Enter budget amount: ");
        budget = scanner.nextDouble();

        System.out.println("Budget set successfully.");
    }
}
