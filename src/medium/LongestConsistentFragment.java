package medium;

/*
 // Write a function: 
 class Solution { public int solution(int[] A); } 
 that, given an array A of N integers, returns the length of the longest consistent fragment of A in which all elements can be generated using at most two different digits. 
 You must use the same digits for all elements.

// [23, 333, 33, 30, 0, 505] returns 4
// - 333, 33, 30, 0
// [615, 88, 498, 99, 9] returns 2
// - 99, 9
// [123, 456] returns 0
 */

import java.util.*;

public class LongestConsistentFragment {
    public static int solution2(int[] A) {
        int maxLength = 0;

        // Traverse each element in the array
        for (int i = 0; i < A.length; i++) {
            // Convert the current element to a string to analyze its digits
            // String numStr = Integer.toString(A[i]);

            // Use a HashSet to keep track of distinct digits in the current fragment
            Set<Character> digits = new HashSet<>();

            // Start from the current index and check subsequent elements
            for (int j = i; j < A.length; j++) {
                String currStr = Integer.toString(A[j]);

                // Check if the current element has at most two distinct digits
                boolean valid = true;
                for (char c : currStr.toCharArray()) {
                    digits.add(c);
                    if (digits.size() > 2) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    // If the current fragment is valid, update the maximum length
                    maxLength = Math.max(maxLength, j - i + 1);
                } else {
                    // If the fragment is not valid, break out of the inner loop
                    break;
                }
            }
        }

        return maxLength;
    }

    public static int solutionJSFail(int[] A) {
        // Initialize variables to track the current fragment and maximum fragment
        // length
        List<Integer> currentFragment = new ArrayList<>();
        int maxFragment = 0;

        // Initialize a set to track unique digits in the current fragment
        Set<Integer> uniqueDigits = new HashSet<>();

        // Iterate over the array
        for (int num : A) {
            // Check if the current fragment contains the number
            if (currentFragment.contains(num)) {
                // Add the number to the set of unique digits
                uniqueDigits.add(num);
            } else {
                // Check if the current fragment is the longest valid fragment found so far
                if (currentFragment.size() > maxFragment && uniqueDigits.size() <= 2) {
                    maxFragment = currentFragment.size();
                }

                // Reset the current fragment to start with the new number
                currentFragment = new ArrayList<>();
                currentFragment.add(num);

                // Reset the set of unique digits to contain only the new number
                uniqueDigits = new HashSet<>();
                uniqueDigits.add(num);
            }
        }

        // Check if the last fragment is the longest valid fragment found
        if (currentFragment.size() > maxFragment && uniqueDigits.size() <= 2) {
            maxFragment = currentFragment.size();
        }

        // Return the length of the longest valid fragment
        return maxFragment;
    }

    public static int solutionOk(int[] A) {
        int maxLength = 0;
        int n = A.length;

        // Iterate over all possible subarrays
        for (int i = 0; i < n; i++) {
            Set<Character> digitSet = new HashSet<>();

            // Check all subarrays starting from index i
            for (int j = i; j < n; j++) {
                // Get set of digits for number A[j]
                Set<Character> currentSet = digitsSet(A[j]);

                // Merge currentSet with digitSet
                digitSet.addAll(currentSet);

                // If the digitSet has more than 2 digits, break the loop
                if (digitSet.size() > 2) {
                    break;
                }

                // Calculate the length of the current subarray
                int currentLength = j - i + 1;

                // Update maxLength if the current subarray meets the criteria
                if (digitSet.size() <= 2) {
                    maxLength = Math.max(maxLength, currentLength);
                }
            }
        }

        return maxLength;
    }

    public static int solution(int[] A) {
        int maxLength = 0;

        // Traverse each element in the array
        for (int i = 0; i < A.length; i++) {
            // Convert the current element to a string to analyze its digits
            // String numStr = Integer.toString(A[i]);

            // Use a HashSet to keep track of distinct digits in the current fragment
            Set<Character> digits = new HashSet<>();

            // Start from the current index and check subsequent elements
            for (int j = i; j < A.length; j++) {
                String currStr = Integer.toString(A[j]);

                // Check if the current element has at most two distinct digits
                boolean valid = true;
                for (char c : currStr.toCharArray()) {
                    digits.add(c);
                    if (digits.size() > 2) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    // If the current fragment is valid, update the maximum length
                    maxLength = Math.max(maxLength, j - i + 1);
                } else {
                    // If the fragment is not valid, break out of the inner loop
                    break;
                }
            }
        }

        return maxLength;
    }

    // Function to get a set of digits used in the given number
    private static Set<Character> digitsSet(int num) {
        Set<Character> set = new HashSet<>();
        while (num > 0) {
            set.add((char) (num % 10 + '0')); // Convert digit to char
            num /= 10;
        }
        return set;
    }

    public static void main(String[] args) {
        int[] A = { 23, 333, 33, 30, 0, 505 }; // returns 4 -> 333, 33, 30, 0
        int[] B = { 615, 88, 498, 99, 9 }; // returns 2 -> 99, 9
        int[] C = { 123, 456 }; // returns 0
        int[] D = { 25, 77, 17, 11, 7, 1, 0, 0 }; // returns 0

        System.out.println(solution2(A));
        System.out.println(solution2(B));
        System.out.println(solution2(C));
        System.out.println(solution2(D));
        System.out.println(solution2(D));

    }
}
