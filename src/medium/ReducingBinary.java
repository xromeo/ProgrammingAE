package medium;

import java.math.BigInteger;

/*
 You are given a string S of length N which encodes a non-negative number V in a binary form. 
 Two types of operations may be performed on it to modify its value: 
 - if V is odd, subtract 1 from it; 
 - if V is even, divide it by 2. 
 
 These operations are performed until the value of V becomes 0 . 
 
 For example, if string S= "011100", its value V initially is 28 . The value of V would change as follows: 
  V=28, which is even: divide by 2 to obtain 14 ; 
  V=14, which is even: divide by 2 to obtain 7 ; 
  V=7, which is odd: subtract 1 to obtain 6; 
  V=6, which is even: divide by 2 to obtain 3 ; 
  V=3, which is odd: subtract 1 to obtain 2 ; 
  V=2, which is even: divide by 2 to obtain 1 ; 
  V=1, which is odd: subtract 1 to obtain 0 . 
  
  Seven operations were required to reduce the value of V to 0 . 
  
  Write a function:  
  class Solution { public int solution(String S); }  

  that, given a string S consisting of N characters containing a binary representation of the initial value V, returns the number of operations after which its value will become 0 . 
  Examples: 
  1. Given S= "011100", the function should return 7 . String S represents the number 28 , which becomes 0 after seven operations, as explained above. 
  
  2. Given S= "111", the function should return 5 . String S encodes the number V=7. 
  Its value will change over the following five operations: 
  V=7, which is odd: subtract 1 to obtain 6; 
  V=6, which is even: divide by 2 to obtain 3 ; 
  V=3, which is odd: subtract 1 to obtain 2 ; 
  V=2, which is even: divide by 2 to obtain 1 ; 
  V=1, which is odd: subtract 1 to obtain 0 . 
  
  3. Given S = "1111010101111", the function should return 22. 
  
  4. Given string S consisting of "1" repeated 400,000 times, the function should return 799,999.

  Write an efficient algorithm for the following assumptions:
  string S is made only of the characters 0 and or 1
  N, which is the length of string S, is an integer within the range [1..1,000,000];
  the binary representation is big-endian, i.e. the first character of string S corresponds to the most significant bit;
  the binary representation may contain leading zeros

 */

public class ReducingBinary {
    
    public static int solutionOkLogicFail2(String S) {
        int operations = 0;
        StringBuilder sb = new StringBuilder(S);

        while (!sb.toString().equals("0")) {
            int length = sb.length();
            // If the last digit is '0', it's even, so we divide by 2 (remove the last
            // digit)
            if (sb.charAt(length - 1) == '0') {
                sb.deleteCharAt(length - 1);
            } else {
                // If it's odd, subtract 1 (change the last '1' to '0')
                int lastOneIndex = sb.lastIndexOf("1");
                sb.setCharAt(lastOneIndex, '0');
                // If we have only '0's left after subtraction, set to "0"
                if (sb.toString().matches("0+")) {
                    sb = new StringBuilder("0");
                }
            }
            operations++;
        }

        return operations;
    }

    public static int solutionOkLogicFail(String S) {
        // Calcular la longitud de la cadena S
        int n = S.length();
        
        // Inicializar el número resultante
        long V = 0;
        long powerOfTwo = 1; // Inicializar como 2^0
        
        // Convertir la cadena binaria a su valor decimal correspondiente
        for (int i = n - 1; i >= 0; i--) {
            if (S.charAt(i) == '1') {
                V += powerOfTwo;
            }
            powerOfTwo <<= 1; // Multiplicar por 2 (corresponde a desplazamiento a la izquierda)
        }
        
        // Contar las operaciones requeridas para llevar V a 0
        int operations = 0;
        while (V > 0) {
            if (V % 2 == 0) {
                V >>= 1; // Dividir por 2 (corresponde a desplazamiento a la derecha)
            } else {
                V--; // Restar 1
            }
            operations++;
        }
        
        return operations;
    }

 


    private static String removeLeadingZeros(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }
        return s.substring(i);
    }
    
    
    public static int solution(String S) {
        // Remove leading zeros
        String s = removeLeadingZeros(S);
        
        // Count zeros and ones
        int zeroCount = 0;
        int oneCount = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                zeroCount++;
            } else {
                oneCount++;
            }
        }
        
        // Calculate the number of operations
        return zeroCount + (oneCount - 1) * 2 + 1;
    }

    public static void main(String[] args) {

        // Test examples
        System.out.println(solution("011100")); // Output: 7
        System.out.println(solution("111")); // Output: 5
        System.out.println(solution("1111010101111")); // Output: 22
        System.out.println(solution("1".repeat(400000))); // Output: 799999
    }
}
