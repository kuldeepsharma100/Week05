package com.ioprogramming.csvdatahandling.basicproblems.writeoncsvfile;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteOnCSVFile {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/ioprogramming/csvdatahandling/basicproblems/writeoncsvfile/EmployeeDetails.csv";
        try{
            FileWriter fw = new FileWriter(filePath);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("ID,Name,Department,Salary\n");
            bw.write("104,Alice Williams,Finance,62000\n");
            bw.write("105,Bob Johnson,Sales,58000\n");
            bw.write("103,Michael Brown,Marketing,55000\n");
            bw.write("102,Jane Smith,HR,50000\n");
            bw.flush();

            System.out.println("CSV file written successfully!");

        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
