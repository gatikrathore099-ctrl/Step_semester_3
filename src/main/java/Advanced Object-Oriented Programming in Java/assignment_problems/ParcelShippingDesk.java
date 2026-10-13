import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Insurable {
    double calculateInsurance(double declaredValue);
}

abstract class Parcel {
    protected double weight;
    protected double declaredValue;

    public Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    public abstract double calculateCharge();
}

class StandardParcel extends Parcel {
    public StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 40.0 + (10.0 * weight);
    }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 80.0 + (15.0 * weight);
    }

    @Override
    public double calculateInsurance(double declaredValue) {
        return declaredValue * 0.02;
    }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 40.0 + (10.0 * weight) + 50.0;
    }

    @Override
    public double calculateInsurance(double declaredValue) {
        return declaredValue * 0.02;
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        List<Parcel> parcels = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double value = scanner.nextDouble();

            switch (type) {
                case "STANDARD":
                    parcels.add(new StandardParcel(weight, value));
                    break;
                case "EXPRESS":
                    parcels.add(new ExpressParcel(weight, value));
                    break;
                case "FRAGILE":
                    parcels.add(new FragileParcel(weight, value));
                    break;
            }
        }
        scanner.close();

        double grandTotal = 0;
        for (Parcel p : parcels) {
            double charge = p.calculateCharge();
            double insurance = 0.0;
            if (p instanceof Insurable) {
                insurance = ((Insurable) p).calculateInsurance(p.declaredValue);
            }
            double total = charge + insurance;
            grandTotal += total;

            String typeStr = p.getClass().getSimpleName().replace("Parcel", "").toUpperCase();
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f\n", typeStr, charge, insurance, total);
        }
        System.out.printf("Grand Total: %.2f\n", grandTotal);
    }
}