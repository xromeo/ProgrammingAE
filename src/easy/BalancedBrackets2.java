package easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedBrackets2 {

    public static boolean balancedBrackets(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {

                if (stack.isEmpty()) {
                    return false;
                }
                char sch = stack.pop();
                if (ch == ')' && sch != '(') {
                    return false;
                }
                if (ch == ']' && sch != '[') {
                    return false;
                }
                if (ch == '}' && sch != '{') {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;

    }

    public static void main(String[] args) {
        String s  = "(){}[]";
        System.out.println(balancedBrackets(s));
        s  = "]";
        System.out.println(balancedBrackets(s));
        s = "()}";
        System.out.println(balancedBrackets(s));
        s = "";
        System.out.println(balancedBrackets(s));
        s = "{[()[]]}";
        System.out.println(balancedBrackets(s));

    }

}
