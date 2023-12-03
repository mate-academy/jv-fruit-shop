package core.basesyntax;

import java.util.List;

public class FruitShopApp {
    public static void main(String[] args) {
        try {

            List<FruitTransaction> transactions = CsvReader
                    .readTransactions("src/main/resources/input.csv");

            transactions = DataProcessor.processTransactions(transactions);

            ReportGenerator.generateReport(transactions, "src/main/resources/output.csv");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
