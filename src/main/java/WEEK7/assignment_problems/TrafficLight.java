public class TrafficLight {
    private final String lightId;
    private String color;

    public TrafficLight(String lightId) {
        this.lightId = lightId;
        this.color = "RED"; // Default start state
    }

    public void next() {
        switch (this.color) {
            case "RED":
                this.color = "GREEN";
                break;
            case "GREEN":
                this.color = "YELLOW";
                break;
            case "YELLOW":
                this.color = "RED";
                break;
            default:
                this.color = "RED";
                break;
        }
    }

    public String getColor() {
        return this.color;
    }

    public String getLightId() {
        return this.lightId;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("Light ID: " + t.getLightId());
        System.out.println("Initial color: " + t.getColor());

        t.next();
        System.out.println("t.next() -> " + t.getColor());

        t.next();
        System.out.println("t.next() -> " + t.getColor());

        t.next();
        System.out.println("t.next() -> " + t.getColor());
    }
}
