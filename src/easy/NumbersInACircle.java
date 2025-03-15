package easy;

/*
 
Given a circular array of N integers (i.e. A[0] and A[N — 1] are adjacent to each other), 
what's the maximum number of adjacent pairs that you can form whose sum are even?
 Note that each element can belong to at most one pair.* 


 You are given N numbers on a circle, described by an array A. 
 Find the maximum number of neighbouring pairs whose sums are even. 
 One element can belong to only one pair. 
 
 Write a function: int solution(int[] A); 
 
 that, given an array A consisting of N integers, returns the maximum number of neighbouring pairs whose sums are even. 
 
 Examples: 
 
 1. Given A = [4,2,5, 8, 7, 3, 7], the function should return 2
 We can create two pairs with even sums: (A[O), A[1]) and (A[4], A[5]). 
 Another way to choose two pairs is: (A[O], A[1]) and (A[5], A[6]). 

 2. Given A = [14, 21, 16, 35, 22], the function should return 1.  
 There is only one qualifying pair (A[0], A[4]) 
 
 3. Given A = [5,5,5,5,5,5), the function should return 3. 
 We can create three pairs: (A[O], A[5]), (A[1], A[2]) and (A[3], A[4]). 
 
 Write an efficient algorithm for the following assumptions: 
 • N is an integer within the range [1..100,000); 
 • each element of array A is an integer within the range [0..1,000,000,000). 
 */

public class NumbersInACircle {
    
    public static int solution(int[] A){

        int N = A.length;
        int count = 0;
        int i = 0;
        boolean taken  = false;
        while(i < N){
            int next = (i + 1) % N;             

            if(next == 0 && taken == true){
                break;
            }

            if(((A[i] + A[next]) & 1) == 0){ // Even = Par
                
                
                if(i == 0){
                    taken = true;
                }
                
                count ++;
                i++;                
            } 
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {4,2,5, 8, 7, 3, 7}; 
        System.out.println(solution(A)); // 2
        int[] B = {14, 21, 16, 35, 22};
        System.out.println(solution(B)); // 1
        int[] C = {5,5,5,5,5,5};
        System.out.println(solution(C)); //3


        int[] D = {5,5,0,1,0,5};
        System.out.println(solution(D)); //1
    }
    
}
