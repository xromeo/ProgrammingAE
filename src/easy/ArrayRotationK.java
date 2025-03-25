package easy;

import java.util.*;

// n = 3, k = 4 => k = 1
        // n = 3, k = 2 => k = k

        // k = 2
        // 1,2,3,4,5 => 5,1,2,3,4 => 4,5,1,2,3
        // 0,1,2,3,4

        // For example, given

        // A = [3, 8, 9, 7, 6]
        // K = 3
        // the function should return [9, 7, 6, 3, 8]. Three rotations were made:

        // [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
        // [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
        // [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]

public class ArrayRotationK {

    public static int[] rotate(int[] a, int k) {

        int n = a.length;
        k = k % n;

        int[] s = new int[n];
        

        for (int i = 0; i < n; i++) {
            int j = (i + k) % n;
            s[j] = a[i];
        }

        return s;
    }




    public static int[] rotate2(int[] a, int k) {

        int n = a.length;
        k = k % n;

        for (int i = 0; i < k; i++) {
            int aux = a[n  - 1];
            for (int j = n - 1; j > 0; j--) {
                a[j] = a[j - 1];
            }
            a[0] = aux;

        }
        
        return a;
    }

    public static int[] rotate3(int[] a, int k) {

        int n = a.length;
        k = k % n;

        int current = 0;
        int next = k;
        int aux = a[next];
        int value = a[current];
        for (int i = 0; i < n; i++) {
            a[next] = value;
            current = next;
            next = (next + k) % n;
            value = aux;
            aux = a[next]; 
        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);            
        }
        System.out.println();

        return a;
        
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5 };
        rotate(a, 2);
        // rotate2(a, 2);
        rotate3(a, 2);
        int[] b = { 3, 8, 9, 7, 6 };
        rotate(b, 3);
        // rotate2(b, 3);
        rotate3(b, 3);
    }


}
