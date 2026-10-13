public class PrimeChecker {
    public static void checkPrime(int n) {
        if (n <= 1) {
            System.out.println(n + " is not prime");
            return;
        }

        boolean isPrime = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            System.out.println(n + " is prime");
        } else {
            System.out.println(n + " is not prime");
        }
    }

    public static void main(String[] args) {
        checkPrime(29);
        checkPrime(21);
    }
}