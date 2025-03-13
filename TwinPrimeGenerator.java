public class TwinPrimeGenerator {

    // Utility method to check if a number is prime
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Method to generate the larger twin prime within the range [min, max]
    public static int generateTwinPrime(int min, int max) {
        // Loop from max to min to find the largest twin prime pair
        for (int m = min; m <= max + 2; m++) {
            // Check if m and m-2 are both prime
            if (isPrime(m) && isPrime(m + 2)) {
                // Return the larger of the twin primes
                return m + 2;
            }
        }
        // If no twin prime pair is found in the range, return -1
        return -1;
    }

    // Main method for testing purposes
    public static void main(String[] args) {
        int min = 95500;
        int max = 96000;
        int twinPrime = generateTwinPrime(min, max);
        System.out.println("The largest twin prime in the range [" + min + ", " + max + "] is: " + twinPrime);
    }
}