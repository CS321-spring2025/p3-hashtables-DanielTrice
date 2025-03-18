/**
 * The TwinPrimeGenerator class provides utility methods to generate twin primes within a specified range.
 */
public class TwinPrimeGenerator {

    /**
     * Utility method to check if a number is prime.
     * 
     * @param num the number to check for primality
     * @return true if the number is prime, false otherwise
     */
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

    /**
     * Method to generate the larger twin prime within the range [min, max], both inclusive.
 
     * @param min the lower bound of the range 
     * @param max the upper bound of the range 
     * @return the larger of the twin prime pair, or -1 if no twin primes are found in the range
     */
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
}