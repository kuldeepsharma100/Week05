package com.ioprogramming.csvdatahandling.advanceproblems.csvtojavaobject;

import java.io.*;
import java.util.*;

public class CSVToStudentList {
    public static void main(String[] args) {
        String fileName = "src/main/java/com/ioprogramming/csvdatahandling/advanceproblems/csvtojavaobject/StudentData.csv";
        List<Student> studentList = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip header row
                    continue;
                }

                String[] data = line.split(",");
                String name = data[0].trim();
                int age = Integer.parseInt(data[1].trim());
                double grade = Double.parseDouble(data[2].trim());

                Student student = new Student(name, age, grade);
                studentList.add(student);
            }
            br.close();

            // Print all student objects
            for (Student s : studentList) {
                s.display();
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid data format in CSV.");
        }
    }
}
