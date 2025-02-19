package com.ioprogramming.csvdatahandling.advanceproblems.mergecsvfile;

import java.io.*;
import java.util.*;

public class MergeCSVFiles {
    public static void main(String[] args) {
        String file1 = "src/main/java/com/ioprogramming/csvdatahandling/advanceproblems/mergecsvfile/student1.csv"; // Contains ID, Name, Age
        String file2 = "src/main/java/com/ioprogramming/csvdatahandling/advanceproblems/mergecsvfile/student2.csv";
        String outputFile = "src/main/java/com/ioprogramming/csvdatahandling/advanceproblems/mergecsvfile/mergedfile.csv";

        Map<String, String[]> studentData = new HashMap<>();

        try {
            // Read first file (ID, Name, Age)
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            String line1;
            boolean isHeader1 = true;

            while ((line1 = br1.readLine()) != null) {
                if (isHeader1) {
                    isHeader1 = false; // Skip header row
                    continue;
                }
                String[] data = line1.split(",");
                String id = data[0].trim();
                studentData.put(id, new String[]{data[1].trim(), data[2].trim()}); // Store Name, Age
            }
            br1.close();

            // Read second file (ID, Marks, Grade)
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            String line2;
            boolean isHeader2 = true;

            while ((line2 = br2.readLine()) != null) {
                if (isHeader2) {
                    isHeader2 = false; // Skip header row
                    continue;
                }
                String[] data = line2.split(",");
                String id = data[0].trim();

                if (studentData.containsKey(id)) {
                    String[] details = studentData.get(id);
                    studentData.put(id, new String[]{details[0], details[1], data[1].trim(), data[2].trim()});
                }
            }
            br2.close();

            // Write merged data to new file
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
            bw.write("ID,Name,Age,Marks,Grade\n"); // Header

            for (String id : studentData.keySet()) {
                String[] details = studentData.get(id);
                bw.write(id + "," + details[0] + "," + details[1] + "," + details[2] + "," + details[3] + "\n");
            }
            bw.close();

            System.out.println("Merged file created successfully: " + outputFile);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
