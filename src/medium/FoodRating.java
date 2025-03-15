package medium;

import java.util.HashMap;
import java.util.Map;

/*
 * A restauranthas launched an app for their food delivery. 'N' reviews about various of their menu items have been submitted. User have submitted a rating out of 5 (1 being worse and 5 being best) The manager wants to know the most loved dish in the restaurant. Find the dish with the highest average rating.
If two dishes are rated the same, return the dish with ths smallest ID
 * 
 */

public class FoodRating {

    static int solution(int N, int[][] ratings) {
        Map<Integer, int[]> dishRatings = new HashMap<>();

        // Calculate total rating and count of reviews for each dish
        for (int[] rating : ratings) {
            int dishId = rating[0];
            int dishRating = rating[1];

            if (!dishRatings.containsKey(dishId)) {
                dishRatings.put(dishId, new int[] { 0, 0 }); // {totalRating, reviewCount}
            }

            int[] currentRating = dishRatings.get(dishId);
            currentRating[0] += dishRating; // Add rating to total rating
            currentRating[1]++; // Increment review count
        }

        int maxAverageRating = 0;
        int mostLovedDish = Integer.MAX_VALUE;

        // Find the dish with the highest average rating
        for (Map.Entry<Integer, int[]> entry : dishRatings.entrySet()) {
            int dishId = entry.getKey();
            int[] ratingInfo = entry.getValue();
            int totalRating = ratingInfo[0];
            int reviewCount = ratingInfo[1];
            int averageRating = totalRating / reviewCount;

            if (averageRating > maxAverageRating || (averageRating == maxAverageRating && dishId < mostLovedDish)) {
                maxAverageRating = averageRating;
                mostLovedDish = dishId;
            }
        }

        return mostLovedDish;
    }

    public static void main(String[] args) {
        int[][] ratings = {
                { 1, 5 },
                { 2, 4 },
                { 1, 4 },
                { 3, 5 },
                { 2, 5 }
        };

        int N = ratings.length;

        int mostLovedDish = solution(N, ratings);

        System.out.println("Most loved dish: " + mostLovedDish);
    }
}
