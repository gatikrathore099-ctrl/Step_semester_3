public class DigitSumAndReverse {
    public static void processNumber(int n) {
        int sum = 0;
        int reverse = 0;
        int temp = n;

        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            reverse = (reverse * 10) + digit;
            temp /= 10;
        }

        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reverse);
    }

    public static void main(String[] args) {
        processNumber(4721);
    }
}