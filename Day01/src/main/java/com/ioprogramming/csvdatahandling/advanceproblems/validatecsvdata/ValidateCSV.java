package com.ioprogramming.csvdatahandling.advanceproblems.validatecsvdata;

import java.io.*;
import java.util.regex.*;

public class ValidateCSV {
    public static void main(String[] args) {
        String inputFile = "src/main/java/com/ioprogramming/csvdatahandling/advanceproblems/validatecsvdata/employee.csv";
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "^[0-9]{10}$";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (isHeader) {
                    isHeader = false; // Skip header row
                    continue;
                }

                String name = data[0].trim();
                String email = data[1].trim();
                String phone = data[2].trim();

                Matcher emailMatcher = emailPattern.matcher(email);
                Matcher phoneMatcher = phonePattern.matcher(phone);

                if (!emailMatcher.matches()) {
                    System.out.println("Invalid Email: " + email + " for Employee: " + name);
                }
                if (!phoneMatcher.matches()) {
                    System.out.println("Invalid Phone Number: " + phone + " for Employee: " + name);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
