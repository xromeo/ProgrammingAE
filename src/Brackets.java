/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 

An input string is valid if:

 

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true

 

Example 2:

Input: s = "()[]{}"

Output: true

 

Example 3:

Input: s = "(]"

Output: false

 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.


([])

))((







*/

import java.util.*;

public class Brackets {

    public static boolean solution(String s){


        Stack<Character> chars = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '{' || ch == '(' || ch == '['){
                chars.add(ch);                
            } else{
                if(chars.isEmpty()){
                    return Boolean.FALSE;
                }
                char sch = chars.pop();
                if(ch == ')' &&  sch != '('){
                    return Boolean.FALSE;
                }
                if(ch == ']' &&  sch != '['){
                    return Boolean.FALSE;
                }
                if(ch == '}' &&  sch != '{'){
                    return Boolean.FALSE;
                }

            }

        }


        return chars.isEmpty() ? Boolean.TRUE: Boolean.FALSE;

    }

    public static void main(String[] args) {
        // System.out.println(solution("([])")); // true
        // System.out.println(solution("()")); // true
        // System.out.println(solution("))(()")); // false
        // System.out.println(solution(")](()")); // false


        System.out.println(solution("((((((((((((")); // false
        System.out.println(solution("))))))))))))")); // false
        System.out.println(solution("([)]")); // false
        System.out.println(solution("{[()]}()")); // true
        System.out.println(solution("{([])")); // false


    }
    


}
