package core.basesyntax.service;

import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.FruitOperationStrategy;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyOperation;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadDataFile {

    private String inputFileName;
    private Map<String, FruitOperationStrategy> operations;

    public ReadDataFile(String inputFileName) {
        this.inputFileName = inputFileName;

        operations = new HashMap<>();
        operations.put("b", new BalanceOperation());
        operations.put("s", new SupplyOperation());
        operations.put("r", new ReturnOperation());
        operations.put("p", new PurchaseOperation());
    }

    public Map<String, Integer> getInputDataFromFile() {
        List<String> inputReadFile = new ArrayList<>();

        try {
            inputReadFile = Files.readAllLines(Path.of(inputFileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read that file!", e);
        }

        Map<String, Integer> fruitQuantity = new HashMap<>();

        for (String currentLine : inputReadFile) {
            if (currentLine.startsWith("type,")) {
                continue;
            }

            String[] fields = currentLine.split(",");

            if (fields.length != 3) {
                continue;
            }

            String type = fields[0];
            String fruit = fields[1];
            int quantity;

            try {
                quantity = Integer.parseInt(fields[2]);
            } catch (NumberFormatException e) {
                continue;
            }

            FruitOperationStrategy strategy = operations.get(type);
            if (strategy != null) {
                strategy.execute(fruitQuantity, fruit, quantity);
            }
        }
        return fruitQuantity;
    }
}
