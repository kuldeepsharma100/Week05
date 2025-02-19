package com.ioprogramming.csvdatahandling.intermediateproblems.filterrecord;

import java.io.BufferedReader;
import java.io.FileReader;

public class FilterRecord {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/ioprogramming/csvdatahandling/intermediateproblems/filterrecord/StudentDetails.csv";
        try{
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            boolean isFirstLine = true;

            String line;
            while((line = br.readLine())!=null){
                if(isFirstLine){
                    isFirstLine = false;
                    continue;
                }
                String [] data = line.split(",");
                if(Integer.parseInt(data[2])>80){
                    System.out.println(line);
                }
            }

        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
