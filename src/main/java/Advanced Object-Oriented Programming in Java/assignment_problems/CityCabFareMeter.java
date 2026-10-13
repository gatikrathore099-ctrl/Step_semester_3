import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface NightService {
    boolean supportsNightService();
}

abstract class Cab {
    protected double km;
    protected String time;

    public Cab(double km, String time) {
        this.km = km;
        this.time = time;
    }

    public abstract double getRatePerKm();

    public Double calculateFare() {
        if ("NIGHT".equals(time)) {
            if (!(this instanceof NightService)) {
                return null; // Rejected
            }
        }

        double fare = km * getRatePerKm();
        fare = Math.max(fare, 100.0);

        if ("NIGHT".equals(time)) {
            fare *= 1.20;
        }
        return fare;
    }
}

class MiniCab extends Cab {
    public MiniCab(double km, String time) {
        super(km, time);
    }

    @Override
    public double getRatePerKm() {
        return 10.0;
    }
}

class SedanCab extends Cab implements NightService {
    public SedanCab(double km, String time) {
        super(km, time);
    }

    @Override
    public double getRatePerKm() {
        return 14.0;
    }

    @Override
    public boolean supportsNightService() {
        return true;
    }
}

class SUVCab extends Cab implements NightService {
    public SUVCab(double km, String time) {
        super(km, time);
    }

    @Override
    public double getRatePerKm() {
        return 18.0;
    }

    @Override
    public boolean supportsNightService() {
        return true;
    }
}

class TripResult {
    String cabType;
    Double fare;
    boolean rejected;

    public TripResult(String cabType, Double fare, boolean rejected) {
        this.cabType = cabType;
        this.fare = fare;
        this.rejected = rejected;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        List<TripResult> results = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String cabType = scanner.next();
            double km = scanner.nextDouble();
            String time = scanner.next();

            Cab cab = null;
            switch (cabType) {
                case "MINI":
                    cab = new MiniCab(km, time);
                    break;
                case "SEDAN":
                    cab = new SedanCab(km, time);
                    break;
                case "SUV":
                    cab = new SUVCab(km, time);
                    break;
            }

            if (cab != null) {
                Double fare = cab.calculateFare();
                if (fare == null) {
                    results.add(new TripResult(cabType, null, true));
                } else {
                    results.add(new TripResult(cabType, fare, false));
                }
            }
        }
        scanner.close();

        double total = 0;
        for (TripResult tr : results) {
            if (tr.rejected) {
                System.out.println(tr.cabType + ": night service not available");
            } else {
                total += tr.fare;
                System.out.printf("%s: %.2f\n", tr.cabType, tr.fare);
            }
        }
        System.out.printf("Total: %.2f\n", total);
    }
}