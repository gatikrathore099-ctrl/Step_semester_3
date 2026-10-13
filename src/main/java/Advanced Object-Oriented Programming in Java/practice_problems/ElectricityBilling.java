import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Connection {
    protected int units;

    public Connection(int units) {
        this.units = units;
    }

    public abstract double calculateBill();
}

class HomeConnection extends Connection {
    public HomeConnection(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        } else {
            return (100 * 5.0) + ((units - 100) * 7.0);
        }
    }
}

class ShopConnection extends Connection {
    public ShopConnection(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return (units * 8.0) + 100.0;
    }
}

class FactoryConnection extends Connection {
    public FactoryConnection(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        double bill = units * 6.0;
        return Math.max(bill, 1000.0);
    }
}

public class ElectricityBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        List<Connection> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();

            switch (type) {
                case "HOME":
                    connections.add(new HomeConnection(units));
                    break;
                case "SHOP":
                    connections.add(new ShopConnection(units));
                    break;
                case "FACTORY":
                    connections.add(new FactoryConnection(units));
                    break;
            }
        }
        scanner.close();

        double total = 0;
        for (Connection c : connections) {
            double bill = c.calculateBill();
            total += bill;
            String typeStr = c.getClass().getSimpleName().replace("Connection", "").toUpperCase();
            System.out.printf("%s: %.2f\n", typeStr, bill);
        }
        System.out.printf("Total: %.2f\n", total);
    }
}