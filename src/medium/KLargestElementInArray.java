package medium;

import java.util.PriorityQueue;

/*
 Kth Largest Element in an Array
Medium
Topics
Companies
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 

Constraints:

1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104
 * 
 */

public class KLargestElementInArray {


    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++){
            q.offer(nums[i]);
            if(q.size() > k){
                q.poll();
            }
        }
        return q.peek();
    }


    public static void main(String[] args) {
        int[] a = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(a, 2));
    }
}