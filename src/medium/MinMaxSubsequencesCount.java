package medium;

/*
# Given an array arr[] consisting of N unique elements, 
# the task is to return the count of the subsequences in an array in which the minimum element is X and the maximum element is Y.

# Examples:

# Input: arr[] = {2, 4, 6, 7, 5}, X = 2, Y = 5
# Output: 2
# Explanation: Subsequences in which the minimum element is X and the maximum element is Y are {2, 5}, {2, 4, 5}.

# Input: arr[] = {2, 4, 6, 7, 5, 1, 9, 10, 11}, X = 2, Y = 7
# Output: 8
# Explanation: subsequences in which the minimum element is X and the maximum element is Y are {2, 4, 6, 7, 5}, {2, 4, 7, 5}, {2, 4, 6, 7}, {2, 4, 7}, 
{2, 6, 7, 5}, {2, 7, 5}, {2, 6, 7}, {2, 7}


*/

/*
 We know that the subsequence will be formed will be in the range (X, Y), 
 and the formula that will come for all the subsequence in the range (X, Y) excluding X and Y will be 2n where n is the number of elements in the range X and Y. 
 Therefore will return the 2n as the answer.
 */

public class MinMaxSubsequencesCount {

    public static int countSubsequences(int[] arr, int X, int Y) {
        int n = arr.length;
        // Initialize a counter to keep track
        // of the number of elements in
        // the range [x, y]
        int cnt = 0;
        for (int i = 0; i < n; i++)
        {
           
            // Check if the element lies
            // within the range (x, y)
            if (arr[i] > X && arr[i] < Y) 
            {
               System.out.println(arr[i]);
                // If so, increment the counter
                cnt++;
            }
        }
 
        // Return 2 raised to the power of cnt,
        // which gives us the number
        // of subsequences
        return (1 << cnt);
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 4, 6, 7, 5};
        int X1 = 2, Y1 = 5;
       // System.out.println("Output for arr1: " + countSubsequences(arr1, X1, Y1)); // Output: 2

        int[] arr2 = {2, 4, 6, 7, 5, 1, 9, 10, 11};
        int X2 = 2, Y2 = 7;
        System.out.println("Output for arr2: " + countSubsequences(arr2, X2, Y2)); // Output: 8
    }
}
