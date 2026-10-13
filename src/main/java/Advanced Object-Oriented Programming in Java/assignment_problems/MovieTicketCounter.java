import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class TicketBooking {
    protected int count;

    public TicketBooking(int count) {
        this.count = count;
    }

    public abstract double calculatePricePerTicket();

    public double calculateTotalAmount() {
        // Convenience fee of 20 per ticket written in one place
        return (calculatePricePerTicket() + 20.0) * count;
    }
}

class RegularBooking extends TicketBooking {
    public RegularBooking(int count) {
        super(count);
    }

    @Override
    public double calculatePricePerTicket() {
        return 150.0;
    }
}

class PremiumBooking extends TicketBooking {
    public PremiumBooking(int count) {
        super(count);
    }

    @Override
    public double calculatePricePerTicket() {
        return 250.0;
    }
}

class ReclinerBooking extends TicketBooking {
    public ReclinerBooking(int count) {
        super(count);
    }

    @Override
    public double calculatePricePerTicket() {
        return 400.0;
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        List<TicketBooking> bookings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String seatType = scanner.next();
            int count = scanner.nextInt();

            switch (seatType) {
                case "REGULAR":
                    bookings.add(new RegularBooking(count));
                    break;
                case "PREMIUM":
                    bookings.add(new PremiumBooking(count));
                    break;
                case "RECLINER":
                    bookings.add(new ReclinerBooking(count));
                    break;
            }
        }
        scanner.close();

        double grandTotal = 0;
        for (TicketBooking b : bookings) {
            double amount = b.calculateTotalAmount();
            grandTotal += amount;
            String seatStr = b.getClass().getSimpleName().replace("Booking", "").toUpperCase();
            System.out.printf("%s: %.2f\n", seatStr, amount);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    }
}