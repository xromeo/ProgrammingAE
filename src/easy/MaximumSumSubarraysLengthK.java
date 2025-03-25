package easy;
/*
 Question:

Given an array of non-negative integers, find the maximum sum among all subarrays of length k.

Example Input:
nums = [2, 1, 5, 1, 3, 2], k = 3

Expected Output:
9  (from subarray [5, 1, 3])

 */
public class MaximumSumSubarraysLengthK {

    public static int findMaxSubArray(int[] nums, int k){

        int sum = 0;
        
        for (int i = 0; i < k; i++) {
            sum += nums[i];            
        }
        int max = sum;

        int sumsa = sum;
        for (int i = k; i < nums.length; i++) {
            sumsa = sumsa - nums[i - k] + nums[i]; 
            max = Math.max(sumsa, max);
        }
        return max;

    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 1, 3, 2};
        System.out.println(findMaxSubArray(nums, 3)); // Output: 9
    }
}


/*
 StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character, Integer> e : f.entrySet()){
            sb.append(e.getKey()).append(e.getValue());
        }
        return sb.toString();
 */