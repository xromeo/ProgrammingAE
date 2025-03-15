package easy;
import java.util.PriorityQueue;

/*
 A movie theater has N seats numbered 1 to N
build a set reservation that performs one of the following operations K times
-fetch the smallest-numbered unreserved seat then reserves it and returns its number
-Cancel a seat reservation for seat[i]

The result should be an array containing the reserved seat numbers

if seat[i] = 0  reserve the seat
if seat[i] > 0 cancel the reservation

every time we reserve a seat it is guaranteed that there is an unreserved seat
Every time we cancel the reservation of a seat, it is guaranteed that the seat is reeserved 
 
 */

public class SeatReservation {

    public static int[] reserveSeats(int N, int K, int[] seat) {
        PriorityQueue<Integer> unreservedSeats = new PriorityQueue<>();
        int[] result = new int[K];

        
        for (int i = 1; i <= N; i++) {
            unreservedSeats.offer(i);
        }

        int index = 0;
        for (int i = 0; i < K; i++) {            

            if (seat[i] == 0) {
                // Fetch the smallest unreserved seat
                int available = unreservedSeats.poll();
                result[index++] = available;
            } else {
                // Cancel reservation
                int available = i;
                result[index++] = 0;
                unreservedSeats.offer(available);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int N = 10; // Number of seats
        int K = 5; // Number of operations
        int[] operations = {
            0, // Reserve seat
            1, // Cancel reservation for seat 1
            0, // Reserve seat
            0, // Reserve seat
            0  // Reserve seat
        };

        int[] reservedSeats = reserveSeats(N, K, operations);

        // Output reserved seat numbers
        for (int seat : reservedSeats) {
            System.out.println(seat);
        }
    }
}
