import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface SaverMode {
    boolean supportsSaverMode();
}

abstract class Appliance {
    protected double hours;
    protected boolean requestedSaver;

    public Appliance(double hours, boolean requestedSaver) {
        this.hours = hours;
        this.requestedSaver = requestedSaver;
    }

    public abstract double getPowerRating();

    public Double calculateUnits() {
        if (requestedSaver) {
            if (!(this instanceof SaverMode)) {
                return null;
            }
        }

        double units = (getPowerRating() * hours) / 1000.0;
        if (requestedSaver) {
            units *= 0.75;
        }
        return units;
    }
}

class Fridge extends Appliance {
    public Fridge(double hours, boolean requestedSaver) {
        super(hours, requestedSaver);
    }

    @Override
    public double getPowerRating() {
        return 150.0;
    }
}

class ACAppliance extends Appliance implements SaverMode {
    public ACAppliance(double hours, boolean requestedSaver) {
        super(hours, requestedSaver);
    }

    @Override
    public double getPowerRating() {
        return 1500.0;
    }

    @Override
    public boolean supportsSaverMode() {
        return true;
    }
}

class TV extends Appliance {
    public TV(double hours, boolean requestedSaver) {
        super(hours, requestedSaver);
    }

    @Override
    public double getPowerRating() {
        return 100.0;
    }
}

class Washer extends Appliance implements SaverMode {
    public Washer(double hours, boolean requestedSaver) {
        super(hours, requestedSaver);
    }

    @Override
    public double getPowerRating() {
        return 500.0;
    }

    @Override
    public boolean supportsSaverMode() {
        return true;
    }
}

class ApplianceReportResult {
    String name;
    Double units;
    boolean notSupported;

    public ApplianceReportResult(String name, Double units, boolean notSupported) {
        this.name = name;
        this.units = units;
        this.notSupported = notSupported;
    }
}

public class ApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        List<ApplianceReportResult> results = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double hours = scanner.nextDouble();
            boolean saver = false;
            if (scanner.hasNext()) {
                String nextWord = scanner.next();
                if ("SAVER".equals(nextWord)) {
                    saver = true;
                }
            }

            Appliance app = null;
            switch (type) {
                case "FRIDGE":
                    app = new Fridge(hours, saver);
                    break;
                case "AC":
                    app = new ACAppliance(hours, saver);
                    break;
                case "TV":
                    app = new TV(hours, saver);
                    break;
                case "WASHER":
                    app = new Washer(hours, saver);
                    break;
            }

            if (app != null) {
                Double units = app.calculateUnits();
                if (units == null) {
                    results.add(new ApplianceReportResult(type, null, true));
                } else {
                    results.add(new ApplianceReportResult(type, units, false));
                }
            }
        }
        scanner.close();

        double totalCost = 0;
        for (ApplianceReportResult ar : results) {
            if (ar.notSupported) {
                System.out.println(ar.name + ": saver mode not supported");
            } else {
                double cost = ar.units * 8.0;
                totalCost += cost;
                System.out.printf("%s: Units=%.2f Cost=%.2f\n", ar.name, ar.units, cost);
            }
        }
        System.out.printf("Total Cost: %.2f\n", totalCost);
    }
}