class HallTicket {
    String studentName;
    int seatNumber;

    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class HallTicketReferenceDemo {
    public static void main(String[] args) {
        // Step 1: Create initial object and point second variable to same reference
        HallTicket priya = new HallTicket("Priya", 0);
        HallTicket copy = priya;

        // Step 2: Modify through second reference variable
        copy.seatNumber = 45;

        // Step 3: Print modified value via original reference
        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));

        // Step 4: Create separate object with identical values and compare references
        HallTicket separate = new HallTicket("Priya", 45);
        System.out.println("separate == priya: " + (separate == priya));
    }
}
