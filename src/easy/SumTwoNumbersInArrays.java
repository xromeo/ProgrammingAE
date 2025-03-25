package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 Add two numbers represented by two arrays
Last Updated : 14 Oct, 2023
Given two array A[0….n-1] and B[0….m-1] of size n and m respectively, representing two numbers such that every element of arrays represent a digit. For example, A[] = { 1, 2, 3} and B[] = { 2, 1, 4 } represent 123 and 214 respectively. The task is to find the sum of both the number. In above case, answer is 337. 

Examples : 

Input : n = 3, m = 3
        a[] = { 1, 2, 3 }
        b[] = { 2, 1, 4 }
Output : 337
123 + 214 = 337
Input : n = 4, m = 3
        a[] = { 9, 5, 4, 9 }
        b[] = { 2, 1, 4 }
Output : 9763
 */

class Result {
    int number;
    int[] arrayNumber;

    public Result(int number, int[] arrayNumber) {
        this.number = number;
        this.arrayNumber = arrayNumber;
    }

    public int getNumber() {
        return number;
    }

    public int[] getArrayNumber() {
        return arrayNumber;
    }

}

public class SumTwoNumbersInArrays {

    public static Result sum(int[] a, int[] b) {

        int i = a.length - 1;
        int j = b.length - 1;
        int carry = 0;
        List<Integer> r = new ArrayList<>();
        while (i >= 0 || j >= 0 || carry > 0) {
            int d1 = (i >= 0) ? a[i] : 0;
            int d2 = (j >= 0) ? b[j] : 0;
            int s = d1 + d2 + carry;

            carry = s / 10;
            int d = s % 10;
            r.add(d);

            i--;
            j--;
        }

        
        Collections.reverse(r);
        
        int[] result = new int[r.size()];
        
        int number = 0;
        for (int k = 0; k < r.size(); k++) {
            result[k] = r.get(k);
            number = number * 10 + r.get(k);
        }

        System.out.println(r);
        System.out.println(number);

        return new Result(number, result);
    }

    public static void main(String[] args) {
        int[] a = { 7, 0, 9, 7, 0, 0 };
        int[] b = { 7, 6, 5, 4 };
        sum(a, b);
    }

}
