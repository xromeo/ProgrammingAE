package medium;
/*
 * There are N coins, each showing either heads or tails. we would like all the coins to form a sequence of alternating heads and tails. What is the minimum number of coins that must be reversed to achieve this?

Wite a function class Solution {public int solution(int [] A);}

that given an array A consisting of N integers representing the coins, returns the minimum number of coins that must be reversed. Consecutive elements of array A represent consecutive coin and contain either a 0 (heads) or a 1 (tails)

Example 
Given array A = [1,0,1,0,1,1] the function should return 1. After reversing the sixth coin, we achieve an alternating sequence of coins [1,0,1,0,1,0]

Given array A = [1,1,0,1,1] the function should return 2. after reversing the first and fifth coins, we achieve an alternating sequence [0,1,0,1,0]
 * 
 */
public class AlternatingCoins {
    public static int solution(int[] A) {
        int n = A.length;
        
        // Define two alternating patterns: pattern1 starts with 0, pattern2 starts with 1
        int[] pattern1 = new int[n];
        int[] pattern2 = new int[n];
        
        for (int i = 0; i < n; i++) {
            pattern1[i] = i % 2;  // pattern1: 0,1,0,1,...
            pattern2[i] = (i + 1) % 2;  // pattern2: 1,0,1,0,...
        }
        
        // Count mismatches with pattern1 and pattern2
        int countMismatchPattern1 = 0;
        int countMismatchPattern2 = 0;
        
        for (int i = 0; i < n; i++) {
            if (A[i] != pattern1[i]) {
                countMismatchPattern1++;
            }
            if (A[i] != pattern2[i]) {
                countMismatchPattern2++;
            }
        }
        
        // Return the minimum number of flips required
        return Math.min(countMismatchPattern1, countMismatchPattern2);
    }

    public static int solution2(int[] A) {
        // Count flips when starting with 0 (heads) and 1 (tails)
        int flipsStartWith0 = 0;
        int flipsStartWith1 = 0;
        
        for (int i = 0; i < A.length; i++) {
            // If the position is even and the coin does not match the expected value,
            // or if the position is odd and the coin matches the expected value,
            // we need to flip the coin for the sequence starting with 0
            if ((i % 2 == 0 && A[i] != 0) || (i % 2 == 1 && A[i] == 0)) {
                flipsStartWith0++;
            }
            // Apply the same logic for the sequence starting with 1
            if ((i % 2 == 0 && A[i] != 1) || (i % 2 == 1 && A[i] == 1)) {
                flipsStartWith1++;
            }
        }
        
        // Return the minimum number of flips needed
        return Math.min(flipsStartWith0, flipsStartWith1);
    }

    public static void main(String[] args) {
        

        // Test example
        int[] A = {1, 0, 1, 0, 1, 1};
        System.out.println(solution(A));  // Output: 1
        int[] D =  {1,1,0,1,1};
        System.out.println(solution(D));  // Output: 2
    }
}
