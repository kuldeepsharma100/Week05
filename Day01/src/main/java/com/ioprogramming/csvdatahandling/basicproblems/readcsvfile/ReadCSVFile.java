package com.ioprogramming.csvdatahandling.basicproblems.readcsvfile;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadCSVFile {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/ioprogramming/csvdatahandling/basicproblems/readcsvfile/StudentDetails.csv";

        try{
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while((line = br.readLine())!=null){
                String [] data = line.split(",");
                System.out.println(data[0] + "," + data[1] + "," + data[2] + ","+ data[3]);
            }


        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
