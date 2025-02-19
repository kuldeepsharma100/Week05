package com.ioprogramming.csvdatahandling.intermediateproblems.sortcsvrecord;
import java.io.*;
import java.util.*;
public class SortCSVBySalary {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/ioprogramming/csvdatahandling/intermediateproblems/sortcsvrecord/employee.csv"; // CSV file path
        List<Employee> employees = new ArrayList<>();

        // Read CSV and store employees in a list
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine(); // Read header (skip it)
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    employees.add(new Employee(parts[0], parts[1], parts[2], Integer.parseInt(parts[3])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sort employees by salary in descending order
        employees.sort(new Comparator<Employee>() {
            public int compare(Employee e1, Employee e2) {
                return e2.salary - e1.salary; // Descending order
            }
        });

        // Print top 5 highest-paid employees
        System.out.println("Top 5 Highest-Paid Employees:");
        for (int i = 0; i < Math.min(5, employees.size()); i++) {
            Employee e = employees.get(i);
            System.out.println(e.id + " " + e.name + " " + e.department + " " + e.salary);
        }
    }
}