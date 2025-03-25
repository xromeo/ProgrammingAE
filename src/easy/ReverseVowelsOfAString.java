package easy;
/*
 Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

 

Example 1:

Input: s = "IceCreAm"

Output: "AceCreIm"

Explanation:

The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

Example 2:

Input: s = "leetcode"

Output: "leotcede"

 

Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters.
 */

import java.util.Set;

public class ReverseVowelsOfAString {


    public static String reverseVowels1(String s) {
        String vowels = "";
        for(int i = 0; i < s.length(); i++){
            char ch = Character.toUpperCase(s.charAt(i));
            if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
                vowels += s.charAt(i);
            }
        }

        String result = "";
        int idx = vowels.length() - 1;
        for(int i = 0; i < s.length(); i++){
            char ch = Character.toUpperCase(s.charAt(i));
            if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
                result += vowels.charAt(idx);
                idx--;
            } else {
                result += s.charAt(i);
            }
        }
        return result;
    }

    public static String reverseVowels(String s) {

        if(s.length() <=1 ) return s;

        char[] arr = s.toCharArray();

        Set<Character> vowels = Set.of('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');
        int i=0;
        int j=s.length()-1;

        while(i<j){
            while( i < j && !vowels.contains(s.charAt(i))){
                i++;
            }
            while( i < j && !vowels.contains(s.charAt(j))){
                j--;
            }

            if(i < j){
                char temp = s.charAt(i);
                arr[i] = s.charAt(j);
                arr[j] = temp;

                i++;
                j--;
            }    
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String s = "IceCreAm";
        System.out.println(reverseVowels(s));
    }
}
