package easy;

/*
 You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

 

Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
 

Constraints:

1 <= flowerbed.length <= 2 * 104
flowerbed[i] is 0 or 1.
There are no two adjacent flowers in flowerbed.
0 <= n <= flowerbed.length
 */
public class CanPlaceFlowers {
    public static boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int i = 0;
        int c = 0;
        int m = flowerbed.length;
        int prev = 0;
        while (i < m) {
            int post = (i + 1) < m ? flowerbed[i + 1] : 0;
            if (flowerbed[i] == 0 && prev == 0 && post == 0) {
                c++;
                flowerbed[i] = 1;
            }
            prev = flowerbed[i];
            i++;

        }
        return n <= c;
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int length = flowerbed.length;

        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 0) {
                
                boolean leftEmpty = (i == 0) || (flowerbed[i - 1] == 0);
                boolean rightEmpty = (i == length - 1) || (flowerbed[i + 1] == 0);

                if (leftEmpty && rightEmpty) {
                    flowerbed[i] = 1; 
                    count++;
                }
            }
        }

        return count >= n;
    }

    public static void main(String[] args) {
        //int[] a = { 1, 0, 0, 0, 0, 1 };
        int[] a = { 0 };
        System.out.println(canPlaceFlowers(a, 1));
    }
}
