import db.DataBase;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import core.basesyntax.FruitTransaction;
import core.basesyntax.FruitInventory;
import service.CsvReaderService;
import service.CsvWriterService;
import service.TransactionProcessor;

public class Main {
    public static void main(String[] args) {
        CsvReaderService csvReaderService = new CsvReaderService();
        CsvWriterService csvWriterService = new CsvWriterService();
        DataBase dataBase = new DataBase();
        TransactionProcessor transactionProcessor = new TransactionProcessor(dataBase);

        String inputFilePath = "src/main/resources/input.csv";
        String outputFilePath = "src/main/resources/output.csv";

        try {
            List<FruitTransaction> transactions = csvReaderService.readTransactions(inputFilePath);
            transactionProcessor.processTransactions(transactions);

            String fruit = "banana";
            FruitInventory inventory = dataBase.getOrCreateInventory();
            dataBase.updateInventory(fruit, inventory);

            List<String> inventoryData = new ArrayList<>();
            inventoryData.add("fruit,quantity");

            for (Map.Entry<String, Integer> entry : inventory.getInventory().entrySet()) {
                inventoryData.add(entry.getKey() + "," + entry.getValue());
            }

            csvWriterService.writeData(outputFilePath, inventoryData);
            System.out.println("Report has been written to " + outputFilePath);
        } catch (IOException e) {
            throw new RuntimeException("File operation error", e);
        }
    }
}
