import java.util.Arrays; // For potential min/max, but manual is fine

class Solution {
    /**
     * Finds the maximum number of petals the frog can collect.
     * The frog can make a maximum of N-2 jumps, meaning it visits N-1 lily pads.
     * Since jumps are to adjacent pads, it implies collecting petals from a contiguous subarray of length N-1.
     * There are only two such contiguous subarrays of length N-1:
     * 1. A[0] to A[N-2] (skipping the last pad A[N-1])
     * 2. A[1] to A[N-1] (skipping the first pad A[0])
     * To maximize the sum, we calculate the sum of all elements and subtract the minimum of the first and last element.
     *
     * @param N The number of lily pads.
     * @param A An array containing the count of fallen petals on each lily pad.
     * @return The maximum number of petals collected.
     */
    public int frogInPond(int N, int[] A) {
        // N is always greater than 2, so N-1 will be at least 2.
        // There will always be at least two pads to consider.

        long totalSum = 0; // Use long for sum to prevent potential overflow if N and petal counts are large.
                           // Although problem output is int, intermediate sum can exceed int max.
        for (int i = 0; i < N; i++) {
            totalSum += A[i];
        }

        // The maximum petals collected will be the total sum minus the minimum of the two possible
        // pads that could be skipped: the first pad (A[0]) or the last pad (A[N-1]).
        // This is because to get a contiguous sub-array of length N-1 from an array of N,
        // you must exclude either the first element or the last element.
        
        // Find the minimum of the first and last elements.
        int minSkippedPetals = Math.min(A[0], A[N - 1]);

        // The result is the total sum minus the petals of the skipped pad.
        return (int) (totalSum - minSkippedPetals);
    }
}
