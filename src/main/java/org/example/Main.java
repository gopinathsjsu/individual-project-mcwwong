package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the input file name: ");
        String inputFileName = scanner.nextLine();

        System.out.print("Enter the output file name: ");
        String outputFileName = scanner.nextLine();

        if (inputFileName.endsWith(".json")) {
            JSONProcessor.writeCardsToFile(JSONProcessor.readCardsFromFile(inputFileName), outputFileName);
        } else if (inputFileName.endsWith(".csv")) {
            CSVProcessor.processCsvFile(inputFileName, outputFileName);
        } else if (inputFileName.endsWith(".xml")) {
            XMLProcessor.writeCardsToFile(XMLProcessor.readCardsFromFile(inputFileName), outputFileName);
        } else {
            System.out.println("Unsupported file format. Please provide a valid file with .json, .csv, or .xml extension.");
        }

        scanner.close();
    }
}