package easy;
/*Write a function solution that, given an integer N, returns the maximum possible value obtainable by deleting one '5' digit from the decimal representation of N.
It is guaranteed that N will contain at least one '5' digit 
Example 
Given N = 15958 , the function should return 1958
Given N = -5859 , the function should return -589
Given N = -5000 , the function should return 0

N contains at least on '5' digit
N contains at least two digits


*/
public class Deleting5 {
    public static int solution(int N) {
        String strN = Integer.toString(N);
        int maxPossible = Integer.MIN_VALUE;

        // Iterate through each character in the string representation of N
        for (int i = 0; i < strN.length(); i++) {
            if (strN.charAt(i) == '5') {
                // Construct new number by excluding the '5'
                StringBuilder sb = new StringBuilder(strN);
                sb.deleteCharAt(i);
                int newNumber = Integer.parseInt(sb.toString());

                // Update maximum possible value
                if (newNumber > maxPossible) {
                    maxPossible = newNumber;
                }
            }
        }

        return maxPossible;
    }

    public static int solution2(int N) {

        String n = String.valueOf(N);

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n.length(); i++){
            if(n.charAt(i) == '5'){
                StringBuilder sb = new StringBuilder(n);
                sb.deleteCharAt(i);
                int number = Integer.parseInt(sb.toString());
                if(number > max){
                    max = number;
                }
            }
        }

        return max;

    }

    public static void main(String[] args) {
        // Ejemplos de casos de prueba
        System.out.println(solution(15958));  // Output: 1958
        System.out.println(solution(-5859));  // Output: -589  -589 
        System.out.println(solution(-5000));  // Output: 0

        System.out.println(solution2(15958));  // Output: 1958
        System.out.println(solution2(-5859));  // Output: -589
        System.out.println(solution2(-5000));  // Output: 0
    }

}
