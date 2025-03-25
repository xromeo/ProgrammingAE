package easy;

import java.util.HashMap;

/*
 Problem Statement:
The interviewer will only share the following input and output

Example Input: "abcaerac"
Example Output: "a3b1c2e1r1"

So the interviewer should infer the requirement of what the program should do, so the following clarifying questions must be asked to the interviewer:

Is it guaranteed that the input will have only letters?

No, it can be any symbol, letters, numbers, special characters, etc.

Should we consider case-sensitive input?

Yes

Does the output insertion order matter?

If it does, then the best option is to use a LinkedHashMap, otherwise a HashMap will be enough.

After the interviewer answers the clarifying questions, we can conclude that the requirement is:

Provide a function that will return how many times a single symbol appears in the input. Do this for each different symbol.
  
 */
import java.util.*;

public class StringCompression {

    public static String compress(String s){

        SequencedMap<Character,Integer> f = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            f.put(s.charAt(i), f.getOrDefault(s.charAt(i), 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character, Integer> e : f.entrySet()){
            sb.append(e.getKey()).append(e.getValue());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(compress("abcaerac"));
    }
}
