package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]

 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.

 */
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {

            char[] s = strs[i].toCharArray();
            Arrays.sort(s);
            // String k = Arrays.toString(s);
            String k = new String(s);

            if (!groups.containsKey(k)) {
                List<String> g = new ArrayList<>();
                g.add(strs[i]);
                groups.put(k, g);
            } else {
                List<String> g = groups.get(k);
                g.add(strs[i]);
                groups.put(k, g);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : groups.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strings = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagrams(strings));
    }
}
