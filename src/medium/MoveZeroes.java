package medium;
/*
 283. Move Zeroes
Solved
Easy
Topics
Companies
Hint
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 

Follow up: Could you minimize the total number of operations done?
 */
public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int idx = 0; 
        
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[idx] = nums[i];
                idx++;
            }
        }        
        for (int i = idx; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] a = {0,1,0,3,12};
        moveZeroes(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    
}
