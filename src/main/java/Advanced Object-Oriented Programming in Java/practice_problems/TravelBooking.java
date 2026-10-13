import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Booking {
    protected double distanceKm;
    // Shared booking fee written in one place only
    protected static final double BOOKING_FEE = 50.0;

    public Booking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public abstract double calculateBaseFare();

    public double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends Booking {
    public BusBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return distanceKm * 2.0;
    }
}

class TrainBooking extends Booking {
    public TrainBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return distanceKm * 1.5;
    }
}

class FlightBooking extends Booking {
    public FlightBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return 2500.0 + (distanceKm * 4.0);
    }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        List<Booking> bookings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String mode = scanner.next();
            double distance = scanner.nextDouble();

            switch (mode) {
                case "BUS":
                    bookings.add(new BusBooking(distance));
                    break;
                case "TRAIN":
                    bookings.add(new TrainBooking(distance));
                    break;
                case "FLIGHT":
                    bookings.add(new FlightBooking(distance));
                    break;
            }
        }
        scanner.close();

        for (Booking b : bookings) {
            double total = b.calculateTotal();
            String modeStr = b.getClass().getSimpleName().replace("Booking", "").toUpperCase();
            System.out.printf("%s: %.2f\n", modeStr, total);
        }
    }
}