package com.ioprogramming.csvdatahandling.advanceproblems.detectduplicates;

import java.io.*;
import java.util.*;

public class DetectDuplicatesCSV {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/ioprogramming/csvdatahandling/advanceproblems/detectduplicates/employees.csv"; // Change to your CSV file
        detectDuplicates(filePath);
    }

    public static void detectDuplicates(String filePath) {
        Set<String> idSet = new HashSet<>();
        List<String> duplicateRecords = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the header row
                }

                String[] data = line.split(",");
                if (data.length > 0) {
                    String id = data[0].trim();

                    if (!idSet.add(id)) {
                        duplicateRecords.add(line);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Print duplicate records
        if (duplicateRecords.isEmpty()) {
            System.out.println("No duplicate records found.");
        } else {
            System.out.println("Duplicate records found:");
            for (String record : duplicateRecords) {
                System.out.println(record);
            }
        }
    }
}
