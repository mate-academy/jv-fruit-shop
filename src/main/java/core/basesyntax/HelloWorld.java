package core.basesyntax;

import java.util.HashMap;
import java.io.*;
import java.util.*;

/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorld {
    public static class Main {
        public static void main(String[] arg) {
            // 1. Read the data from the input CSV file
            String inputFile = "input.csv";
            String outputFile = "output.csv";

            try {
                FruitShopService fruitShopService = new FruitShopService();
                fruitShopService.processFile(inputFile);
                fruitShopService.writeToFile(outputFile);

                System.out.println("Report successfully written to file " + outputFile);
            } catch (IOException e) {
                throw new RuntimeException("Error reading from file", e);
            }
        }

        static class FruitShopService {

            private Map<String, Integer> fruitShop = new HashMap<>();
            private final Map<String, OperationStrategy> operation = new HashMap<>();

            public FruitShopService() {
                operation.put("b", new Balance());
                operation.put("s", new Supply());
                operation.put("p", new Purchase());
                operation.put("r", new Return());
            }

            public void processFile(String inputFile) throws IOException {
                try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
                    String line;

                    while ((line = reader.readLine()) != null) {
                        String[] lines = line.split(",");
                        String operation = lines[0].trim();
                        int quantity = Integer.parseInt(lines[2].trim());

                        OperationStrategy operationStrategy = operationsMap.get(operation);

                        if (operationStrategy != null) {
                            operationStrategy.execute(fruitShop, lines[1].trim(), quantity);
                        } else {
                            throw new RuntimeException("Unknown operation: " + operation);
                        }
                    }
                }
            }

            public void writeToFile(String outputFile) throws IOException {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                    writer.write("fruit,quantity");
                    writer.newLine();

                    for (Map.Entry<String, Integer> entry : fruitShop.entrySet()) {
                        writer.write(entry.getKey() + "," + entry.getValue());
                        writer.newLine();
                    }
                }
            }
        }

        interface OperationStrategy {
            void execute(Map<String, Integer> fruitShop, String fruit, int quantity);
        }

        static class Balance implements OperationStrategy {
            @Override
            public void execute(Map<String, Integer> fruitShop, String fruit, int quantity) {
                fruitShop.put(fruit, quantity);
            }
        }

        static class Supply implements OperationStrategy {
            @Override
            public void execute(Map<String, Integer> fruitShop, String fruit, int quantity) {
                int currentQuantity = fruitShop.getOrDefault(fruit, 0);
                if (currentQuantity - quantity < 0) {
                    throw new RuntimeException("Not enough stock for selling " + fruit);
                }
                fruitShop.put(fruit, currentQuantity - quantity);
            }
        }

        static class Purchase implements OperationStrategy {
            @Override
            public void execute(Map<String, Integer> fruitShop, String fruit, int quantity) {
                int currentQuantity = fruitShop.getOrDefault(fruit, 0);
                if (currentQuantity - quantity < 0) {
                    throw new RuntimeException("Not enough stock for purchase " + fruit);
                }
                fruitShop.put(fruit, currentQuantity - quantity);
            }
        }

        static class Return implements OperationStrategy {
            @Override
            public void execute(Map<String, Integer> fruitShop, String fruit, int quantity) {
                int currentQuantity = fruitShop.getOrDefault(fruit, 0);
                fruitShop.put(fruit, currentQuantity + quantity);
            }
        }
    }
}
