package medium;

import java.util.*;
/*
 
 User
A restaurant has launched an app for their food delivery. 'N' reviews about various of their menu items have been submitted. User have submitted a rating out of 5 (1 being worse and 5 being best) The manager wants to know the most loved dish in the restaurant. Find the dish with the highest average rating.
If two dishes are rated the same, return the dish with ths smallest ID

The first line contains N denoting the number of reviews
Netx, the N line contain two integers each, the ID and rating of the i^th review


Print a single integer, representing the ID of the highest-rated dish.

Constraints

1 <= N <= 10⁵
1 <= ratings[i][0] <= 10⁹
1 <= ratings[i][1] <= 5

Sample input 

4
512 2
123 3
987 4
123 5

Sample output 

123

Explanation

Given 

512 2
123 3
987 4
123 5

Since we need to return the dish with the highest average rating, we need to calculate the average first

The unique dish that is repeated is the 123, so its average rating will be:

average = (3+5)/2 = 4

The other dishes only have one rating. The average rating are:

average_ratings = [512, 2],  [123, 4], [987, 4]

Now, both dishes 123 and 987 have average ratings of 4 but 123 is numerically smaller, which means the solution should return 123


 */

public class FoodRatings {

    static int foodRatings(int N, int[][] ratings) {
        Map<Integer, int[]> dishRating = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int id = ratings[i][0];
            int rate = ratings[i][1];

            if (!dishRating.containsKey(id)) {
                dishRating.put(id, new int[] { 0, 0 });
            }

            int[] currentRate = dishRating.get(id);
            currentRate[0] += rate;
            currentRate[1]++;

            dishRating.put(id, currentRate);

        }

        System.out.println(dishRating);

        int maxAverage = 0;
        int loved = Integer.MAX_VALUE;

        for(Map.Entry<Integer, int[]> entry : dishRating.entrySet()){
            int id = entry.getKey();
            int[] rateInfo = entry.getValue();
            int total = rateInfo[0];
            int count = rateInfo[1];
            int average = total / count;

            if(average > maxAverage || (average == maxAverage && id < loved )){
                maxAverage = average;
                loved = id;
            }
        }

        return loved;

    }

    public static void main(String[] args) {

        int[][] ratings = {

                { 512, 2 },
                { 123, 3 },
                { 987, 4 },
                { 123, 5 }
        };

        System.out.println(foodRatings(4, ratings));

    }

}
