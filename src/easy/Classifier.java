package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Classifier {

    /*
     * 
     * Given two lists of numbers:
     * 
     * Create two new lists C and D.
     * C must contain elements present in A and B
     * D must contain elements present in B but not present in A.
     * Lists are ordered, can contained repeated elements, and may be of different
     * sizes.
     */


    public static void classifier(List<Integer> a, List<Integer> b){

        List<Integer> c = new ArrayList<>();
        List<Integer> d = new ArrayList<>();

        for (Integer e : a) {
            if(b.contains(e)){
                c.add(e);
            }
        }

        for (Integer e : b) {
            if(!a.contains(e)){
                d.add(e);
            }
        }


        c = a.stream().filter(e -> b.contains(e)).toList();

        d = b.stream().filter(e -> !a.contains(e)).toList();

        System.out.println(c);
        System.out.println(d);

    }

 

    public static void classify(List<Integer> listA, List<Integer> listB) {

        // listA.retainAll(listB);
        // listA.stream().forEach(e -> System.out.println(e));

        List<Integer> listC = listA.stream().filter(e-> listB.contains(e)).toList();
        listC.stream().forEach(e -> System.out.println(e));

        List<Integer> listD = listB.stream().filter(e-> !listA.contains(e)).toList();
        listD.stream().forEach(e -> System.out.println(e));
    }

    // public static void main(String[] args) {

    //     classify(new ArrayList<>(List.of(1, 2, 3, 5, 10)), new ArrayList<>(List.of(2, 2, 5, 11, 13)));

    // }




    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        list.add(5.4);
        list.add(1.2);
        classifier(List.of(1,2,3,4,5), List.of(2,3,4, 7));
    }


}
