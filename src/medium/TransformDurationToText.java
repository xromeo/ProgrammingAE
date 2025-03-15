package medium;

/*
 You task in this challenge is to write a function that transform a duration (given as a number of seconds) to readable text.
The function must accept a non-negative integer. If it is zero, it just return "now". Otherwise the duration is expressed as a combination of years, days, hours, minutes and seconds.

example For seconds = 62, your function should return "1 minute and 2 seconds"
 */

public class TransformDurationToText {

    public static String solution(int seconds) {
        if (seconds == 0) {
            return "now";
        }

        // Define time units in seconds
        int minute = 60;
        int hour = 60 * minute;
        int day = 24 * hour;
        int year = 365 * day;

        // Calculate the components
        int years = seconds / year;
        seconds %= year;
        int days = seconds / day;
        seconds %= day;
        int hours = seconds / hour;
        seconds %= hour;
        int minutes = seconds / minute;
        seconds %= minute;

        // Construct the readable text
        StringBuilder formattedDuration = new StringBuilder();
        if (years > 0) {
            formattedDuration.append(years).append(" year").append(years > 1 ? "s" : "");
        }
        if (days > 0) {
            if (formattedDuration.length() > 0) {
                formattedDuration.append(", ");
            }
            formattedDuration.append(days).append(" day").append(days > 1 ? "s" : "");
        }
        if (hours > 0) {
            if (formattedDuration.length() > 0) {
                formattedDuration.append(", ");
            }
            formattedDuration.append(hours).append(" hour").append(hours > 1 ? "s" : "");
        }
        if (minutes > 0) {
            if (formattedDuration.length() > 0) {
                formattedDuration.append(", ");
            }
            formattedDuration.append(minutes).append(" minute").append(minutes > 1 ? "s" : "");
        }
        if (seconds > 0) {
            if (formattedDuration.length() > 0) {
                formattedDuration.append(", and ");
            }
            formattedDuration.append(seconds).append(" second").append(seconds > 1 ? "s" : "");
        }

        return formattedDuration.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(62)); // Output: "1 minute and 2 seconds"
        System.out.println(solution(0));  // Output: "now"
    }
