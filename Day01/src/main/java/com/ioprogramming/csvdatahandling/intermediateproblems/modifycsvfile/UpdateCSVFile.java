package com.ioprogramming.csvdatahandling.intermediateproblems.modifycsvfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class UpdateCSVFile {
    public static void main(String[] args) {
        String source = "src/main/java/com/ioprogramming/csvdatahandling/intermediateproblems/modifycsvfile/source.csv";
        String destination = "src/main/java/com/ioprogramming/csvdatahandling/intermediateproblems/modifycsvfile/destination.csv";

        try{
            FileReader fr = new FileReader(source);
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter(destination);
            BufferedWriter bw = new BufferedWriter(fw);

            String line;
            while((line = br.readLine())!=null){
                String [] data = line.split(",");

                if("IT".equalsIgnoreCase(data[2])){
                    data[3] = String.valueOf(Double.parseDouble(data[3])*1.10);
                    bw.write(Arrays.toString(data));
                    bw.newLine();
                    bw.flush();
                }else {
                    bw.write(line);
                    bw.newLine();
                    bw.flush();
                }
            }
            System.out.println("data modified successfully");

        }catch (Exception e){

        }
    }
}
