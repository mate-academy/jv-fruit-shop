package core.basesyntax;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class FruitShop {
    public static void main(String[] args) {
        String inputFilePath = "input.csv";
        String outputFilePath = "report.csv";

        try {
            List<FruitTransaction> transactions = ReadService.readTransactions(inputFilePath);
            Map<String, Integer> fruitStock = ProcessService.processTransactions(transactions);
            ReportService.generateReport(fruitStock, outputFilePath);
            System.out.println("Report generated successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
