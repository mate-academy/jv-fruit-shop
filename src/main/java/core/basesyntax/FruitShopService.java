package core.basesyntax;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

class FruitShopService {

    private Map<String, Integer> fruitShop = new HashMap<>();
    private final Map<String, OperationStrategy> operationsMap = new HashMap<>();

    public FruitShopService() {
        operationsMap.put("b", new Balance());
        operationsMap.put("s", new Supply());
        operationsMap.put("p", new Purchase());
        operationsMap.put("r", new Return());
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
                    throw new RuntimeException("Неизвестная операция: " + operation);
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
