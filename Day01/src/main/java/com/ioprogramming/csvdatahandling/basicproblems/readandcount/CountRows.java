package com.ioprogramming.csvdatahandling.basicproblems.readandcount;

import java.io.BufferedReader;
import java.io.FileReader;

public class CountRows {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/ioprogramming/csvdatahandling/basicproblems/readandcount/data.csv";
        try{
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            int count=0;
            String line;
            while((line = br.readLine())!=null){
                count++;
            }

            System.out.println("The number of rows is : " + (count-1));

        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
