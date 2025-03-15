package easy;

import java.util.Arrays;
import java.util.*;

/*
 We will call a sequence of integers a spike if they first increase (strictly) and then decrease (also strictly, including the last element of the increasing part). 
 For example (4, 5, 7, 6, 3, 2) is a spike, but (1, 1, 5, 4, 3) and (1, 4, 3, 5) are not. Note that the increasing and decreasing parts always intersect, e.g.: for spike (3, 5, 2) sequence (3, 5) is an increasing part and sequence (5, 2) is a decreasing part, and for spike (2) sequence (2) is both an increasing and a decreasing part. 
 
 Your are given an array A of N integers. Your task is to calculate the length of the longest possible spike, which can be created from numbers from array A. Note that you are NOT supposed to find the longest spike as a sub-sequence of A, but rather choose some numbers from A and reorder them to create the longest spike. 
 
 Write a function: 

 class Solution { public int solution (int[] A); } 
 
 which, given an array A of integers of length N, returns the length of the longest spike which can be created from the numbers from A. 
 
 Examples: 
 
 1. Given A = [1, 2], your function should return 2, because (1, 2) is already a spike. 
 2. Given A = [2, 5, 3, 2, 4, 1], your function should return 6, because we can create the following spike of length 6: (2, 4, 5, 3, 2, 1). 
 3. Given A = [2, 3, 3, 2, 2, 2, 1], your function should return 4, because we can create the following spike of length 4: (2, 3, 2, 1) and we cannot create any longer spike. Note that increasing and decreasing parts should be strictly increasing/decreasing and they always intersect. 
 
 Write an efficient algorithm for the following assumptions: N is an integer within the range [1..100,000]; • each element of array A is an integer within the range [1..1,000,000].


 */
public class SpikeIncreaseDecrease {

    public static int solution(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int maxVal = Integer.MIN_VALUE;
        
        // Populate the frequency map and find the maximum value in the array
        for (int num : A) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            maxVal = Math.max(maxVal, num);
        }
        
        int result = 1; // At least one occurrence of the most frequent value is counted
        // Calculate the result by iterating through the frequency map
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            
            // Exclude the maximum value from additional counts if it's not the only one
            if (num != maxVal) {
                result += Math.min(2, count); // Add at most 2 occurrences of each value
            }
        }
        
        return result;
    }



    public static void main(String[] args) {
        

        // Test examples
        int[] A1 = {1, 2};
        int[] A2 = {2, 5, 3, 2, 4, 1};
        int[] A3 = {2, 3, 3, 2, 2, 2, 1};
        System.out.println(solution(A1));  // Output: 2
        System.out.println(solution(A2));  // Output: 6
        System.out.println(solution(A3));  // Output: 4
    }
    
}
