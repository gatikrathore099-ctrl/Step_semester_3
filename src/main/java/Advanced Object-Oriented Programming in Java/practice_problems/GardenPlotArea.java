import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Plot {
    protected String owner;

    public Plot(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public abstract double calculateArea();
}

class CirclePlot extends Plot {
    private double radius;

    public CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class RectanglePlot extends Plot {
    private double length, width;

    public RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

class TrianglePlot extends Plot {
    private double base, height;

    public TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

public class GardenPlotArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        List<Plot> plots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String shape = scanner.next();
            String owner = scanner.next();

            switch (shape) {
                case "CIRCLE":
                    double radius = scanner.nextDouble();
                    plots.add(new CirclePlot(owner, radius));
                    break;
                case "RECTANGLE":
                    double length = scanner.nextDouble();
                    double width = scanner.nextDouble();
                    plots.add(new RectanglePlot(owner, length, width));
                    break;
                case "TRIANGLE":
                    double base = scanner.nextDouble();
                    double height = scanner.nextDouble();
                    plots.add(new TrianglePlot(owner, base, height));
                    break;
            }
        }
        scanner.close();

        double totalArea = 0;
        for (Plot p : plots) {
            double area = p.calculateArea();
            totalArea += area;
            String shapeName = p.getClass().getSimpleName().replace("Plot", "").toUpperCase();
            System.out.printf("%s (%s): %.2f\n", p.getOwner(), shapeName, area);
        }
        System.out.printf("Total Area: %.2f\n", totalArea);
    }
}