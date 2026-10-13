import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface TransportUser {
    boolean usesBus();
}

abstract class Student {
    protected String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateTuitionAndHostelFee();

    public double calculateTotalFee() {
        double baseFee = calculateTuitionAndHostelFee();
        if (this instanceof TransportUser && ((TransportUser) this).usesBus()) {
            baseFee += 12000.0;
        }
        return baseFee;
    }
}

class DayScholar extends Student implements TransportUser {
    public DayScholar(String name) {
        super(name);
    }

    @Override
    public double calculateTuitionAndHostelFee() {
        return 40000.0;
    }

    @Override
    public boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {
    public Hosteller(String name) {
        super(name);
    }

    @Override
    public double calculateTuitionAndHostelFee() {
        return 40000.0 + 60000.0;
    }
}

class ScholarshipStudent extends Student implements TransportUser {
    public ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    public double calculateTuitionAndHostelFee() {
        return 20000.0;
    }

    @Override
    public boolean usesBus() {
        return true;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();

            switch (type) {
                case "DAY_SCHOLAR":
                    students.add(new DayScholar(name));
                    break;
                case "HOSTELLER":
                    students.add(new Hosteller(name));
                    break;
                case "SCHOLAR":
                    students.add(new ScholarshipStudent(name));
                    break;
            }
        }
        scanner.close();

        double totalCollected = 0;
        for (Student s : students) {
            double fee = s.calculateTotalFee();
            totalCollected += fee;
            System.out.printf("%s: %.2f\n", s.getName(), fee);
        }
        System.out.printf("Total Collected: %.2f\n", totalCollected);
    }
}