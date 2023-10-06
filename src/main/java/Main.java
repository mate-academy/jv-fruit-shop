import core.basesyntax.FruitTransaction;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import service.CsvReaderService;
import service.CsvWriterService;

public class Main {
    public static void main(String[] args) {
        CsvReaderService csvReaderService = new CsvReaderService();
        CsvWriterService csvWriterService = new CsvWriterService();

        String inputFilePath = "C:\\Users\\BEST\\IdeaProjects\\jv-fruit-shop\\src\\main\\resources\\input.csv";
        String outputFilePath = "C:\\Users\\BEST\\IdeaProjects\\jv-fruit-shop\\src\\main\\resources\\output.csv";

        try {
            Map<String, Integer> fruitInventory = new HashMap<>();

            final List<FruitTransaction> transactions
                    = csvReaderService.readTransactions(inputFilePath);
            Map<FruitTransaction.Operation, BiConsumer<String, Integer>> operationMap
                    = new HashMap<>();
            operationMap.put(FruitTransaction.Operation.BALANCE, (fruit, quantity) ->
                    fruitInventory.put(fruit, fruitInventory.getOrDefault(fruit, 0) + quantity));
            operationMap.put(FruitTransaction.Operation.SUPPLY, (fruit, quantity) ->
                    fruitInventory.put(fruit, fruitInventory.getOrDefault(fruit, 0) + quantity));
            operationMap.put(FruitTransaction.Operation.PURCHASE, (fruit, quantity) -> {
                if (fruitInventory.containsKey(fruit)) {
                    int currentQuantity = fruitInventory.get(fruit);
                    if (currentQuantity >= quantity) {
                        fruitInventory.put(fruit, currentQuantity - quantity);
                    } else {
                        throw new RuntimeException("Not enough " + fruit + " in inventory");
                    }
                } else {
                    throw new RuntimeException("Fruit " + fruit + " not found in inventory");
                }
            });
            operationMap.put(FruitTransaction.Operation.RETURN, (fruit, quantity) -> {
                if (fruitInventory.containsKey(fruit)) {
                    int currentQuantity = fruitInventory.get(fruit);
                    fruitInventory.put(fruit, currentQuantity + quantity);
                } else {
                    throw new RuntimeException("Fruit " + fruit + " not found in inventory");
                }
            });

            for (FruitTransaction transaction : transactions) {
                String fruit = transaction.getFruit();
                int quantity = transaction.getQuantity();
                FruitTransaction.Operation operation = transaction.getOperation();

                BiConsumer<String, Integer> operationFunction = operationMap.get(operation);
                if (operationFunction != null) {
                    operationFunction.accept(fruit, quantity);
                } else {
                    throw new RuntimeException("Unknown operation: " + operation);
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
