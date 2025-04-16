package easy;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;

/*
 Given an array of integers and a target value, determine the number of pairs of array elements that have a
difference equal to the target value.

Example 
k=1
arr = [1,2,3,4]

there are three values that differ by k = 1: 2-1 = 1, 3-2 = 1, and 4-3 = 1. Return 3.
 */
public class Pairs {
    public static int pairs(int k, List<Integer> array) {
        Set<Integer> set = new HashSet<>(array);

        //array.stream().forEach(e -> set.add(e));

        //Collections.sort(array);

        // e - x = k -> e - k = x
        
        return array
                .stream()
                .filter(e -> set.contains(e - k))    
                //.peek(e -> System.out.println(e))
                .collect(Collectors.toList())
                .size();
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(List.of(1, 2, 3, 4));
        //System.out.println(pairs(1, A)); // 3
        A = new ArrayList<>(List.of(1, 5, 3, 4, 2));
        System.out.println(pairs(2, A)); // 3
        A = new ArrayList<>(List.of(1, 2, 3, 9, 5));
        //System.out.println(pairs(2, A)); // 2
    }
}
