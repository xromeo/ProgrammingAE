package easy;

/*
 * 
 Rick is a fan of logic-based games. However, he is bored of the classic ones, like Sudoku and Mastermind, since he has solved so many of them.
 Recently he found a new game in which one is given a string with some question marks in it. 
 The objective is to replace all of the question marks with letters (one letter per question mark) in such a way that no letter appears next to another letter of the same kind. 
 
 Write a function: 
 class Solution { public String solution (String riddle); } 
 
 that, given a string riddle, returns a copy of the string with all of the question marks replaced by lowercase letters (a-z) in such a way that the same letters do not occur next to each other. 
 The result can be any of the possible answers as long as it fulfils the above requirements. 
 
 Examples: 
 1. Given riddle = "ab?ac?", your function might return "abcaca". Some other possible results are "abzacd", "abfacf". 
 2. Given riddle = "rd?e?wg??", your function might return "rdveawgab". 
 3. Given riddle = "????????", your function might return "codility". 
 
 Write an efficient algorithm for the following assumptions: • the length of the string is within the range [1...100,000); • string riddle consists only of lowercases letters (a – z) or '?'; • it is always possible to turn string 'riddle' into a string without two identical consecutive letters.
 */

import java.util.*;

public class Riddle {

    public static String solution(String riddle) {
        char[] result = new char[riddle.length()];
        Set<Character> availableLetters = new HashSet<>();

        // Initialize available letters from 'a' to 'z'
        for (char ch = 'a'; ch <= 'z'; ch++) {
            availableLetters.add(ch);
        }

        // Initialize previous character to an arbitrary value
        char prevChar = ' ';

        for (int i = 0; i < riddle.length(); i++) {
            char currentChar = riddle.charAt(i);

            if (currentChar != '?') {
                // Use the given character if it's not a question mark
                result[i] = currentChar;
                prevChar = currentChar;
            } else {
                // Replace '?' with a valid letter
                for (char ch : availableLetters) {
                    if (ch != prevChar) {
                        result[i] = ch;
                        prevChar = ch;
                        availableLetters.remove(ch);
                        break;
                    }
                }
            }
        }

        return new String(result);
    }

    public static void main(String[] args) {

        // Test examples
        String riddle1 = "ab?ac?";
        System.out.println(solution(riddle1)); // Output: "abcaca"

        String riddle2 = "rd?e?wg??";
        System.out.println(solution(riddle2)); // Output: "rdveawgab"

        String riddle3 = "????????";
        System.out.println(solution(riddle3)); // Output: "codility"
    }
}
