package org.example;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVProcessor{

    public static void processCsvFile(String inputFileName, String outputFileName) {
        try (CSVReader reader = new CSVReader(new FileReader(inputFileName));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFileName))) {

            String[] record;
            while ((record = reader.readNext()) != null) {
                // Assuming the CSV format is cardNumber,expirationDate,cardHolderName
                String cardNumber = record[0];
                String expirationDate = record[1];
                String cardHolderName = record[2];

                String errorMessage = Processor.determineErrorMessage(cardNumber);

                if (!errorMessage.isEmpty()) {
                    // Handle invalid credit card and write the error message
                    writer.writeNext(new String[]{cardNumber, errorMessage});
                } else {
                    // Credit card is valid, create CreditCard instance
                    CreditCard creditCard = Processor.getCreditCard(cardNumber, expirationDate, cardHolderName);

                    // Process the credit card instance as needed
                    if (creditCard != null && creditCard.isValid()) {
                        // Write the details to the output file
                        writer.writeNext(new String[]{cardNumber, expirationDate, cardHolderName, Processor.getCardType(creditCard)});
                    } else {
                        // Handle invalid credit card
                        writer.writeNext(new String[]{cardNumber + ",Invalid credit card"});
                    }
                }
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }


}
