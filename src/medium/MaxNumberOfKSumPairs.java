package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array.
 

Example 1:

Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.
Example 2:

Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109
1 <= k <= 109

 */
public class MaxNumberOfKSumPairs {


    public int maxOperations2(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int count = 0;

        while(i < j) {
            int sum = nums[i] + nums[j];

            if(sum == k) {
                count++;
                i++;
                j--;
            } else if(sum < k) {
                i++;
            } else {
                j--;
            }
        }

        return count;
    }

    public static int maxOperations(int[] nums, int k) {        
        Map<Integer, Integer> f = new HashMap<>();
        int total = 0;
        for(int e : nums){
            int d = k - e;
            if(f.containsKey(d) && f.get(d) > 0){
                total++;
                f.put(d, f.get(d) - 1);
            } else {
                f.put(e, f.getOrDefault(e, 0) + 1);    
            }
        }
        
        return total;
    }

    public static void main(String[] args) {

        int[] a = {1,2,3,4};
        System.out.println(maxOperations(a, 5));
        int[] b = {3,1,3,4,3};
        System.out.println(maxOperations(b, 6));

        
    }
    
}
