import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Journey {
    protected double distance;

    public Journey(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();
}

class BusJourney extends Journey {
    public BusJourney(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        double fare = 2.0 + (0.10 * distance);
        return Math.min(fare, 10.0);
    }
}

class TrainJourney extends Journey {
    public TrainJourney(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return 3.0 + (0.15 * distance);
    }
}

class MetroJourney extends Journey {
    private double peakHourFactor;

    public MetroJourney(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }
}

public class TransportCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        List<Journey> journeys = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double distance = scanner.nextDouble();

            switch (type) {
                case "BUS":
                    journeys.add(new BusJourney(distance));
                    break;
                case "TRAIN":
                    journeys.add(new TrainJourney(distance));
                    break;
                case "METRO":
                    double factor = scanner.nextDouble();
                    journeys.add(new MetroJourney(distance, factor));
                    break;
            }
        }
        scanner.close();

        double grandTotal = 0;
        for (Journey j : journeys) {
            double fare = j.calculateFare();
            grandTotal += fare;
            String typeStr = "";
            if (j instanceof BusJourney) typeStr = "BUS";
            else if (j instanceof TrainJourney) typeStr = "TRAIN";
            else if (j instanceof MetroJourney) typeStr = "METRO";

            System.out.printf("%s: %.2f\n", typeStr, fare);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    }
}