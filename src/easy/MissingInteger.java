package easy;

import java.util.*;
/*
 Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
 */

public class MissingInteger {

    public static int solution2(int[] A) {

        Set<Integer> N = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            N.add(A[i]);
        }
        int r = 0;
        for (int i = 1; i < A.length + 1; i++) {
            if (!N.contains(i)) {
                r = i;
                break;
            }
        }
        return r == 0 ? A.length + 1 : r;

    }

    public static int solution(int[] A) {
        Set<Integer> seen = new HashSet<>();

        // Iterate over the array A and add positive integers to the set
        for (int num : A) {
            if (num > 0) {
                seen.add(num);
            }
        }

        // Start checking from the smallest positive integer (1) upwards
        int smallestMissingPositive = 1;
        while (seen.contains(smallestMissingPositive)) {
            smallestMissingPositive++;
        }

        return smallestMissingPositive;
    }

    public static void main(String[] args) {
        int[] A = {1,3,6,4,1,2}; //5
        System.out.println(solution(A));
        
        int[] B = {1,2,3};  //4
        System.out.println(solution(B));
        
        int[] C = {-1,-3};  //1
        System.out.println(solution(C));
    }

}
