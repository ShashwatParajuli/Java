import java.util.*;

class Account {
    String customerName;
    int accountNumber;
    String accountType;
    double balance;

    Scanner sc = new Scanner(System.in);

    void accept() {
        System.out.print("Enter customer name: ");
        customerName = sc.nextLine();

        System.out.print("Enter account number: ");
        accountNumber = sc.nextInt();
        sc.nextLine(); // consume leftover newline

        System.out.print("Enter account type: ");
        accountType = sc.nextLine();

        System.out.print("Enter initial Balance: ");
        balance = sc.nextDouble();
    }

    void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        balance += amount;
        System.out.println("Amount deposited successfully!");
    }

    void displayBalance() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Current Balance: " + balance);
    }

    void withdraw() {
        System.out.println("Withdraw method not implemented in base class.");
    }

    void computeInterest() {
        System.out.println("Interest computation not applicable for this account type.");
    }

    void checkMinimumBalance() {
        System.out.println("No minimum balance rule defined.");
    }
}

// ---------------- SAVINGS ACCOUNT -----------------
class SavAccount extends Account {
    @Override
    void computeInterest() {
        System.out.print("Enter rate of Interest (%): ");
        double rate = sc.nextDouble();
        System.out.print("Enter time in years: ");
        double time = sc.nextDouble();

        double interest = balance * (Math.pow((1 + rate / 100), time) - 1);
        balance += interest;
        System.out.println("Compound interest added: " + interest);
    }

    @Override
    void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

// ---------------- CURRENT ACCOUNT -----------------
class CurAccount extends Account {
    final double MIN_BALANCE = 1000;
    final double PENALTY = 200;

    @Override
    void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        if (amount <= balance) {
            balance -= amount;
            checkMinimumBalance();
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    @Override
    void checkMinimumBalance() {
        if (balance < MIN_BALANCE) {
            balance -= PENALTY;
            System.out.println("Balance below minimum! Penalty imposed: " + PENALTY);
        }
    }
}

// ---------------- MAIN CLASS -----------------
public class LAB5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account acc;

        System.out.println("Choose account type:");
        System.out.println("1. Saving Account");
        System.out.println("2. Current Account");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        if (choice == 1) {
            acc = new SavAccount();
        } else {
            acc = new CurAccount();
        }

        acc.accept(); // ✅ Corrected (was acc.account())

        int option;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            System.out.println("4. Compute Interest");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            option = sc.nextInt();

            switch (option) {
                case 1 -> acc.deposit();
                case 2 -> acc.withdraw();
                case 3 -> acc.displayBalance(); // ✅ fixed (was displaybalance)
                case 4 -> acc.computeInterest();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid Choice!");
            }
        } while (option != 5);

        sc.close();
    }
}
