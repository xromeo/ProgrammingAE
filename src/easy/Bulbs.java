package easy;

/*
 There are N bulbs, numbered from 1 to N, arranged in a row. The first bulb is plugged into the power socket and each successive bulb is connected to the previous one (the second bulb to the first, the third bulb to the second, etc)

 Initially all the bulbs are turned off. At moment K (for K from 0 to N-1), we turn on the A[K]-th bulb. A bulb shines if it is on and all the previous bulbs are turned on too.
 Write a function solution that, given an array A of N different integers from 1 to N, return the number of moments for which every turned on bulb shines.

 Example A = [2,1,3,5,4], the function should return 3
 * 
 */

public class Bulbs {
    public static int solution(int[] A) {
        int max_seen = 0;
        int shine_count = 0;

        // Iterate through the array A
        for (int K = 0; K < A.length; K++) {
            int bulb = A[K];
            // Update max_seen to be the maximum of max_seen and bulb
            max_seen = Math.max(max_seen, bulb);
            // Check if max_seen is equal to (K + 1)
            if (max_seen == (K + 1)) {
                // Increment shine_count if all bulbs from 1 up to (K + 1) are turned on
                shine_count++;
            }
        }

        return shine_count;
    }

    public static void main(String[] args) {
        

        // Test example
        int[] A = {2, 1, 3, 5, 4};
        System.out.println(solution(A));  // Output: 3
    }
}
