package easy;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsAnagram {

    public static boolean anagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> f = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            f.put(ch, f.getOrDefault(ch, 0) + 1);
        }
        
        for (int i = 0; i < t.length(); i++) {
            Character ch = t.charAt(i);
            if(!f.containsKey(ch) || f.get(ch) == 0){
                return false;
            }

            f.put(ch, f.get(ch) - 1);
        }

        return true;
    }

    public static boolean anagram2(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        char[] as = s.toCharArray();
        char[] at = t.toCharArray();

        Arrays.sort(as);
        Arrays.sort(at);

        if(!Arrays.equals(as, at)){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(anagram("silent","listen"));
        System.out.println(anagram2("silent","listen"));
    }

}
