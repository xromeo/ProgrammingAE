/*
 You are given a log file with a list of GET requests delimited with double quotes and spaces.
A sample and the structure of the text file containing the log entries are given below. 
Sample log record:
unicomp6.unicomp.net - - [01/JuL/1995:00:00: 6 - 0400] "GET /shuttle/countdown/ HTTP/1.0" 200 3985
Log file structure: 
Hostname, -, -, Timestamp, Request, HTTP Response Code, Bytes 
unicomp6.unicomp.net - - [01/Jul/1995:00:00:06 -0400] "GET /shuttle/countdown/ HTTP/1.0" 200 3985
Given a filename that denotes a text file in the current working directory. Create an output file with the name "bytes_." prefixed to the filename (bytes_filename) which stores the information about large responses. 
Example: filename = "hosts_access_log_00.txt, process the records in host_access_log_00.txt and create an output file named bytes_hosts_access_log_00.txt

Write the following to the output file:

1. The first line must contain the number of requests that have more than 5000 bytes sent in their response.
2. The second line must contain the total sum of bytes sent by all responses sending more than 5000 bytes
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LogProcessor {
    public static void main(String[] args) {
        String filename = "hosts_access_log_00.txt";
        processLogFile(filename);
    }

    public static void processLogFile(String filename) {
        String outputFilename = "bytes_" + filename;
        int count = 0;
        long totalBytes = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilename))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");

                // Assuming the structure is fixed as described
                if (parts.length >= 10) {
                    int bytes = Integer.parseInt(parts[10]);
                    if (bytes > 5000) {
                        count++;
                        totalBytes += bytes;
                    }
                }
            }

            // Write to the output file
            writer.write(String.valueOf(count));
            writer.newLine();
            writer.write(String.valueOf(totalBytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
