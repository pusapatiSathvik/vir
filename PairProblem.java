import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solve(int N, int[] A) {
        long totalValidPairs = 0; // Use long to avoid overflow for large counts

        // Store elements of A in a HashSet for efficient lookups
        Set<Integer> setA = new HashSet<>();
        for (int x : A) {
            setA.add(x);
        }

        // Iterate through each number 'targetProduct' present in array A
        // For each 'targetProduct', find all pairs (i, j) whose product is 'targetProduct'
        for (int targetProduct : setA) { // Iterating through setA (or A)
            // Iterate 'i' from 1 up to sqrt(targetProduct)
            // Since i * j = targetProduct, if i > sqrt(targetProduct), then j < sqrt(targetProduct)
            // We find factors up to sqrt(targetProduct) and then use targetProduct/i to get the other factor.
            for (long i = 1; i * i <= targetProduct; i++) {
                if (targetProduct % i == 0) { // If 'i' is a factor of 'targetProduct'
                    long j = targetProduct / i;

                    // Case 1: i and j are distinct factors
                    // This means we have two distinct pairs: (i, j) and (j, i)
                    if (i != j) {
                        totalValidPairs += 2;
                    } else {
                        // Case 2: i and j are the same (i.e., i * i = targetProduct)
                        // This means we only have one pair: (i, i)
                        totalValidPairs += 1;
                    }
                }
            }
        }

        return (int) totalValidPairs; // Cast back to int for return type
    }
}
