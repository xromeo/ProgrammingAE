package medium;

import java.util.PriorityQueue;

/*
 Kth Largest Element in a Stream
Problem Statement:
You're part of a university admission office and need to keep track of the highest test score from applicants in real time. This helps to determine cutoff marks for interviews and admission dynamically as the applicants submit their scores.

You are tasked with implementing a class that, for a given integer k, maintains a stream of test scores and continuously returns the kth highest test score after a new score has been submitted.

Requirements:

Implement the class KthLargest:
KthLargest(int k, int[] nums): Initializes the object with an integer k and a list of test scores.
int add(int val): Adds a new test score to the stream and returns the kth largest score in the list so far.
Clarifications:

We're keeping track of the 3rd largest element (since k = 3). That means we don't return the highest element; we return the third highest in the sorted order.
We are not tracking the maximum score; we are tracking the kth largest.
The chosen data structure always stores exactly k elements, with the smallest of those k elements at the root.
Example:

Call	Numbers in Heap (Size \= 3)	kth Largest
add(3)	[4, 5, 8] (3 is ignored)	4
add(5)	[5, 5, 8]	5
add(10)	[5, 8, 10]	5
add(9)	[8, 9, 10]	8
add(4)	[8, 9, 10] (4 is ignored)	8
Breakdown of add(10)
The current heap before adding 10 is [5, 5, 8], and the kth largest is 5.
We add 10. Since 10 > 5, we remove the smallest element (5) and insert 10.
The new heap becomes [5, 8, 10], where:
10 is the highest.
8 is the second highest.
5 is the third highest (kth largest).
The function returns 5, because we're tracking the third largest element, not the highest.
 * 
 */

public class KLargest {

    PriorityQueue<Integer> q = new PriorityQueue<>();
    int k;

    public KLargest(int[] nums, int k) {        
        this.k = k;
        for (int num : nums) {            
            add(num);
        }
        while (!q.isEmpty()) {
            System.out.print(q.poll() + " ");
        }
    }

    public int add(int val){
        if(q.size() < k){
            q.offer(val);
            return 0;
        }
        q.offer(val);
        q.poll();
        return q.peek();
    }

    public static void main(String[] args) {
        KLargest kLargest = new KLargest(new int[]{4,5,8,2}, 3);

        
        // System.out.println(kLargest.add(3));
        // System.out.println(kLargest.add(5));
        // System.out.println(kLargest.add(10));
        // System.out.println(kLargest.add(9));
        // System.out.println(kLargest.add(4));
    }
}
