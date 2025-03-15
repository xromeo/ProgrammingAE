package medium;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

import java.util.concurrent.*;

/*
 * 
Detective, one of our team members tracked our target, Vincent the tief, to hidden warehouse. We believe this is where he's storing the stolen goods. The entrance to this warehouse is guarded by a digital combination lock. However, our informant isn't entirely certain about the pin they witnessed Vincent input.
The keypath has the following layout
1 | 2 | 3
4 | 5 | 6
7 | 8 | 9
   | 1 |

He noted the pin 1357, but he also said it is possible that each of the digits he saw could actually be another adjacent digit (horizontally or vertically, but not diagonally) 

He also mentioned he knows this kind of lock. You can enter an unlimited amount of wrong PINs, but they never lock the system or sound the alarm. That's why we can try out all possible variations .

All possible in the sense of the observed PIN itself and all variations considering the adjacent digits.

Can you help us to find all those variations? the array should contain all possible PINs ordered in ascending value. 
 * 
 */

public class BeADetective {

    public static String[] solution(String pin) {
        // Define the adjacent digits for each digit
        Map<Character, List<Character>> adjacentDigits = new HashMap<>();
        adjacentDigits.put('1', Arrays.asList('1', '2', '4'));
        adjacentDigits.put('2', Arrays.asList('1', '2', '3', '5'));
        adjacentDigits.put('3', Arrays.asList('2', '3', '6'));
        adjacentDigits.put('4', Arrays.asList('1', '4', '5', '7'));
        adjacentDigits.put('5', Arrays.asList('2', '4', '5', '6', '8'));
        adjacentDigits.put('6', Arrays.asList('3', '5', '6', '9'));
        adjacentDigits.put('7', Arrays.asList('4', '7', '8'));
        adjacentDigits.put('8', Arrays.asList('5', '7', '8', '9', '0'));
        adjacentDigits.put('9', Arrays.asList('6', '8', '9'));
        adjacentDigits.put('0', Arrays.asList('0', '8'));

        // Generate all possible variations
        List<String> variations = new ArrayList<>();
        generateVariations(pin, 0, "", adjacentDigits, variations);

        // Sort the variations in ascending order
        Collections.sort(variations);

        return variations.toArray(new String[0]);
    }

    private static void generateVariations(String pin, int index, String current, Map<Character, List<Character>> adjacentDigits, List<String> variations) {
        if (index == pin.length()) {
            variations.add(current);
            return;
        }

        char digit = pin.charAt(index);
        for (char adjDigit : adjacentDigits.get(digit)) {
            generateVariations(pin, index + 1, current + adjDigit, adjacentDigits, variations);
        }
    }

    public static void main(String[] args) {
        String pin = "1357";
        String[] result = solution(pin);
        System.out.println(Arrays.toString(result));

        
    }
}
