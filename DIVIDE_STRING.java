import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
     * Divides a string into the maximum possible number of subsequences such that
     * every character of S is present in only one subsequence and every subsequence
     * has the same set of characters.
     *
     * The key insight is that if every subsequence must have the same set of characters,
     * this set must be the set of all unique characters present in the original string S.
     * To maximize the number of subsequences (k), each subsequence must contain at least
     * one instance of every unique character. Therefore, 'k' cannot be greater than
     * the minimum frequency of any unique character in the original string S.
     *
     * @param S The input string.
     * @return The maximum possible number of subsequences.
     */
    public int divideString(String S) {
        if (S == null || S.isEmpty()) {
            return 0; // No characters, no subsequences.
        }

        // Step 1: Count the frequency of each character in the string S.
        // A HashMap is flexible for any character set, an int[26] could be used
        // for strictly lowercase English letters for minor performance gain.
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : S.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Find the minimum frequency among all characters present in S.
        // Initialize minFrequency with a very large value.
        int minFrequency = Integer.MAX_VALUE;

        // Iterate over the values (frequencies) in the map.
        for (int count : frequencyMap.values()) {
            minFrequency = Math.min(minFrequency, count);
        }

        // The minimum frequency found is the maximum number of subsequences.
        return minFrequency;
    }
}
