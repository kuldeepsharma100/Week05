package com.ioprogramming.csvdatahandling.intermediateproblems.searchforrecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class SearchRecord {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/ioprogramming/csvdatahandling/intermediateproblems/searchforrecord/StudentRecord.csv";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student name");
        String target = sc.next();
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            boolean isFirstLine = true;
            String line;
            while ((line = br.readLine())!=null){
                if(isFirstLine){
                    isFirstLine = false;
                    continue;
                }
                String [] data = line.split(",");

                if(target.equalsIgnoreCase(data[1])){
                    System.out.println("Student found");
                    return;
                }
            }

            System.out.println("Student not found");
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
