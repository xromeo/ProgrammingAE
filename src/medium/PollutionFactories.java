package medium;

import java.util.PriorityQueue;
import java.util.*;

/*
 
An industrial company has N factories, each producing some pollution every month. 
The company has decided to reduce its total fume emissions by equipping some of the factories with one or more filters. 
Every such filter reduces the pollution of a factory by half. 
When a second (or subsequent) filter is applied, it again reduces by half the remaining pollution emitted after fitting the existing filter(s). 
For example, a factory that initially produces 6 units of pollution will generate 3 units with one filter, 1.5 units with two filters and 0.75 units with three filters. 

You are given an array of N integers describing the amount of pollution produced by the factories. 
Your task is to find the minimum number of filters needed to decrease the total sum of pollution by at least half. 

Write a function: 

class Solution { public int solution(int[] A); } 

which, given an array of integers A of length N, returns the minimum number of filters needed to reduce the total pollution by at least half. 
Examples: 
1. Given A = [5, 19, 8, 1), your function should return 3. The initial total pollution is 5 + 19 +8 +1 = 33. We install two filters at the factory producing 19 units and one filter at the factory producing 8 units. 
Then the total pollution will be 5 + ((19 / 2) / 2) + (8 / 2) + 1 = 5 + 4.75 + 4 + 1 = 14.75 which is less than 33 / 2 = 16.5, so we have achieved our goal. 
2. Given A = [10, 10), your function should return 2, because we may install one filter at each factory. 
3. Given A = [3,0,5), your function should return 2, because it is sufficient to install one filter at each factory producing a non-zero amount of pollution.

 * 
 */

public class PollutionFactories {

    static public int solution(int[] A) {
        PriorityQueue<Double> maxHeap = new PriorityQueue<>((x, y) -> Double.compare(y, x));
        double totalPollution = 0;
        for (int pollution : A) {
            if (pollution > 0) { // Only add non-zero pollution factories to the heap
                totalPollution += pollution;
                maxHeap.add((double) pollution);
            }
        }
        
        double targetPollution = totalPollution / 2;
        int filters = 0;
        
        while (!maxHeap.isEmpty() && totalPollution > targetPollution) {
            double current = maxHeap.poll();
            double reduced = current / 2;
            totalPollution -= reduced;
            if (reduced > 0) { // Only add the reduced pollution if it's greater than 0
                maxHeap.add(reduced);
            }
            filters++;
        }
        
        return filters;
    }



    public static int solutionO(int[] F){
        
        PriorityQueue<Double> q = new PriorityQueue<>(Comparator.reverseOrder());
        // PriorityQueue<Double> q2 = new PriorityQueue<>((a,b) ->{
        //     if (a < b){
        //         return 1;
        //     } 
        //     if (a > b){
        //         return -1;
        //     }
        //     return 0;
        // });

        //PriorityQueue<Double> q2 = new PriorityQueue<>((a,b) -> Double.compare(b, a));
        //PriorityQueue<Double> q2 = new PriorityQueue<>((a,b) -> { return Double.valueOf(b-a).intValue();});  not recomended ???


        double total = 0;
        
        for (int f : F) {
            total += f;            
            q.offer((double)f);            
        }

        int count = 0;
        double target = total / 2;
        while(total > target){
            System.out.println(q.peek());
            double value = q.poll();
            
            total -= value / 2; 
            
            q.offer(value / 2);            
            count ++;
        }

        return count;

    }


    public static void main(String[] args) {
        

        // Test examples
        int[] A1 = {5, 19, 8, 1};
        System.out.println(solution(A1));  // Output: 3
        
        int[] A2 = {10, 10};
        System.out.println(solution(A2));  // Output: 2
        
        int[] A3 = {3, 0, 5};
        System.out.println(solution(A3));  // Output: 2
    }
}
