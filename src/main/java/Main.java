import core.basesyntax.FruitTransaction;
import service.CsvReaderService;
import service.CsvWriterService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CsvReaderService csvReaderService = new CsvReaderService();
        CsvWriterService csvWriterService = new CsvWriterService();

        String inputFilePath = "input.csv";
        String outputFilePath = "output.csv";

        try {
            List<FruitTransaction> transactions = csvReaderService.readTransactions(inputFilePath);

            Map<String, Integer> fruitInventory = new HashMap<>();

            for (FruitTransaction transaction : transactions) {
                String fruit = transaction.getFruit();
                int quantity = transaction.getQuantity();

                switch (transaction.getOperation()) {
                    case BALANCE:
                    case SUPPLY:
                        fruitInventory.put(fruit, fruitInventory.getOrDefault(fruit, 0)
                                + quantity);
                        break;
                    case PURCHASE:
                        if (fruitInventory.containsKey(fruit)) {
                            int currentQuantity = fruitInventory.get(fruit);
                            if (currentQuantity >= quantity) {
                                fruitInventory.put(fruit, currentQuantity - quantity);
                            } else {
                                throw new RuntimeException("Not enough " + fruit
                                        + " in inventory");
                            }
                        } else {
                            throw new RuntimeException("Fruit " + fruit
                                    + " not found in inventory");
                        }
                        break;
                    case RETURN:
                        if (fruitInventory.containsKey(fruit)) {
                            int currentQuantity = fruitInventory.get(fruit);
                            fruitInventory.put(fruit, currentQuantity + quantity);
                        } else {
                            throw new RuntimeException("Fruit " + fruit
                                    + " not found in inventory");
                        }
                        break;
                    default:
                        throw new RuntimeException("Unknown operation: "
                                + transaction.getOperation());
                }
            }

            List<String> combinedData = new ArrayList<>();
            combinedData.add("fruit,quantity");

            for (Map.Entry<String, Integer> entry : fruitInventory.entrySet()) {
                combinedData.add(entry.getKey() + "," + entry.getValue());
            }

            csvWriterService.writeData(outputFilePath, combinedData);
            System.out.println("Report has been written to " + outputFilePath);
        } catch (IOException e) {
            throw new RuntimeException("File operation error", e);
        }
    }
}
