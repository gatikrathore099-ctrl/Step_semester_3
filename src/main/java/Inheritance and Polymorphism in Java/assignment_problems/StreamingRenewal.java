import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Subscriber {
    protected String name;
    protected LocalDate startDate;

    public Subscriber(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public abstract LocalDate calculateRenewalDate();
}

class BasicPlan extends Subscriber {
    public BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(30);
    }
}

class StandardPlan extends Subscriber {
    public StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(90);
    }
}

class PremiumPlan extends Subscriber {
    public PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        List<Subscriber> subscribers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            LocalDate startDate = LocalDate.parse(scanner.next());

            switch (type) {
                case "BASIC":
                    subscribers.add(new BasicPlan(name, startDate));
                    break;
                case "STANDARD":
                    subscribers.add(new StandardPlan(name, startDate));
                    break;
                case "PREMIUM":
                    subscribers.add(new PremiumPlan(name, startDate));
                    break;
            }
        }
        scanner.close();

        for (Subscriber s : subscribers) {
            LocalDate renewalDate = s.calculateRenewalDate();
            System.out.println(s.getName() + ": " + renewalDate);
        }
    }
}