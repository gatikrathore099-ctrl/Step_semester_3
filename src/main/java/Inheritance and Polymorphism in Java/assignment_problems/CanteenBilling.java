import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Customer {
    protected double amount;

    public Customer(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();
}

class Student extends Customer {
    public Student(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.90;
    }
}

class Staff extends Customer {
    public Staff(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.95;
    }
}

class Guest extends Customer {
    public Guest(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount + 10.0;
    }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();

            switch (type) {
                case "STUDENT":
                    customers.add(new Student(amount));
                    break;
                case "STAFF":
                    customers.add(new Staff(amount));
                    break;
                case "GUEST":
                    customers.add(new Guest(amount));
                    break;
            }
        }
        scanner.close();

        double grandTotal = 0;
        for (Customer c : customers) {
            double finalAmount = c.calculateFinalAmount();
            grandTotal += finalAmount;
            String className = c.getClass().getSimpleName().toUpperCase();
            System.out.printf("%s: %.2f\n", className, finalAmount);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    }
}