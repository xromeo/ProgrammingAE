package medium;
/*
 A non-empty array A consisting of N non-negative integers is given. Its binarian is defined as:

binarian(A)=pow2(A[0]) + pow2(A[1]) + ... + pow2(A[N-1]) pow2(K) = 2 ^ K

For example, the binarian of array A such that: [1, 5, 4] equals 50:

binarian(A)=pow2(A[0]) + pow2(A[1])+ pow2(A[2]) = pow2(1)+ pow2(5)+ pow2(4) = 2 + 32 + 16 = 50

Write a function:

Copy
class Solution{public int solution(int[] A)};
that, given an array A consisting of N non-negative integers, returns the length of the shortest array that has the same binarian as array A. 
For example, given array A such that [1,0,2,0,0,2] the function should return 3 because: • the binarian of A is 13

• array B such that B[0] = 3, B[1] = 2 and B[2] = 0 also has a binarian of 13,

• there is no shorter array with a binarian of 13.

Write an efficient algorithm for the following assumptions: • N is an integer within the range [1..100,000] • each element of array A is an integer within the range[0..10,000].
 


la representación binaria de 13 es 1101

*/

import java.util.*;

public class Binarian {

    public static int solution(int[] A) {

        int binarian = 0;
        for (int n : A) {
            binarian += Math.pow(2, n);
        }

        List<Integer> result = new ArrayList<>();
        int power = 0;
        while (binarian > 0){
            if((binarian & 1) == 1){   // If the least significant bit is 1
                result.add(power);
            }
            binarian = binarian >> 1;  //  Right shift binaria => divide 2  
            // Por ejemplo, si binarian es 1101 (que representa 13 en decimal), entonces binarian >>= 1 cambiará binarian a 110 (que representa 6 en decimal).
            power++;
        }

        System.out.println(result);
        
        Collections.reverse(result);
        
        System.out.println(result);

        return result.size();

    }

    public static void main(String[] args) {
        int[] A = { 1, 0, 2, 0, 0, 2 };
        System.out.println(solution(A));
    }

}
