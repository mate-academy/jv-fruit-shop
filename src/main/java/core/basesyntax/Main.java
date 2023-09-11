package core.basesyntax;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "input.csv";
        final String outputFilePath = "output.csv";

        FileReaderService fileReaderService = new CsvFileReader();
        List<String> transactionData;
        try {
            transactionData = fileReaderService.readData(inputFilePath);
        } catch (IOException e) {
            System.err.println("Error opening/reading file: " + e.getMessage());
            return;
        }

        TransactionParser transactionParser = new CsvTransactionParser();
        List<FruitTransaction> transactions = transactionParser.parseTransactions(transactionData);

        Storage storage = new Storage();

        DefaultOperationStrategy operationStrategy = new DefaultOperationStrategy();

        TransactionProcessor transactionProcessor;
        transactionProcessor = new TransactionProcessor(operationStrategy, storage);
        transactionProcessor.processTransactions(transactions);

        ReportCreator reportCreator = new CsvReportCreator(outputFilePath);

        Map<String, Integer> fruitInventory = storage.getFruitInventory();
        try {
            reportCreator.createReport(fruitInventory, outputFilePath);
        } catch (IOException e) {
            System.err.println("Error creating report: " + e.getMessage());
        }
    }
}
