import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Transaction {
    protected double amount;

    public Transaction(double amount) {
        this.amount = amount;
    }

    public abstract double calculateAdjustedAmount();
}

class CardTransaction extends Transaction {
    public CardTransaction(double amount) {
        super(amount);
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount * 1.02;
    }
}

class WalletTransaction extends Transaction {
    public WalletTransaction(double amount) {
        super(amount);
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount * 1.01;
    }
}

class BankTransferTransaction extends Transaction {
    public BankTransferTransaction(double amount) {
        super(amount);
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount;
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        List<Transaction> transactions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();

            switch (type) {
                case "CARD":
                    transactions.add(new CardTransaction(amount));
                    break;
                case "WALLET":
                    transactions.add(new WalletTransaction(amount));
                    break;
                case "BANKTRANSFER":
                    transactions.add(new BankTransferTransaction(amount));
                    break;
            }
        }
        scanner.close();

        double grandTotal = 0;
        for (Transaction t : transactions) {
            double adjusted = t.calculateAdjustedAmount();
            grandTotal += adjusted;
            String className = t.getClass().getSimpleName().replace("Transaction", "").toUpperCase();
            if (className.equals("BANKTRANSFER")) {
                className = "BANKTRANSFER";
            }
            System.out.printf("%s: %.2f\n", className, adjusted);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    }
}