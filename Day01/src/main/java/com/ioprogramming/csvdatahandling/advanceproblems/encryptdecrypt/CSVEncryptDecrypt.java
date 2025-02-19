package com.ioprogramming.csvdatahandling.advanceproblems.encryptdecrypt;

import java.io.*;
import java.util.Base64;

public class CSVEncryptDecrypt {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/ioprogramming/csvdatahandling/advanceproblems/encryptdecrypt/employee.csv";

        // Writing encrypted data
        writeCSV(filePath);

        // Reading and decrypting data
        readCSV(filePath);
    }

    // Method to encrypt a text using Base64
    public static String encrypt(String text) {
        return Base64.getEncoder().encodeToString(text.getBytes());
    }

    // Method to decrypt a text using Base64
    public static String decrypt(String encryptedText) {
        return new String(Base64.getDecoder().decode(encryptedText));
    }

    // Writing encrypted data to CSV file
    public static void writeCSV(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("ID,Name,Email,Salary\n");
            writer.write("1,John," + encrypt("john@example.com") + "," + encrypt("50000") + "\n");
            writer.write("2,Sara," + encrypt("sara@example.com") + "," + encrypt("60000") + "\n");
            System.out.println("Encrypted data written to CSV.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Reading and decrypting data from CSV file
    public static void readCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("\nDecrypted Data from CSV:");
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals("ID")) {
                    System.out.println(line); // Print header
                } else {
                    String decryptedEmail = decrypt(parts[2]);
                    String decryptedSalary = decrypt(parts[3]);
                    System.out.println(parts[0] + "," + parts[1] + "," + decryptedEmail + "," + decryptedSalary);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
