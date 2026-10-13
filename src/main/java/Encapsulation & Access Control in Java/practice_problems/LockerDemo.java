
class Locker {
    private final int lockerNumber;
    private String combinationCode;

    public Locker(int lockerNumber, String combinationCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = combinationCode;
    }

    public void changeCode(String currentCode, String newCode) {
        if (combinationCode.equals(currentCode)) {
            combinationCode = newCode;
            System.out.println("Code changed successfully");
        } else {
            System.out.println("Code change rejected: incorrect current code");
        }
    }

    public int getLockerNumber() {
        return lockerNumber;
    }
}

public class LockerDemo {
    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");

        l.changeCode("1234", "5678");
        l.changeCode("0000", "9999");

        System.out.println("Locker number: " + l.getLockerNumber());
    }
}
