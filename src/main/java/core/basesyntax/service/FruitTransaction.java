package core.basesyntax.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class FruitTransaction {
    private Operation operation;
    private final int OPERATION_POSITION = 0;
    private final int FRUIT_POSITION = 1;
    private final int QUANTITY_POSITION = 2;
    private final String DATA_SEPARATOR = ",";
    public static final String DATA_BUILDER_SEPARATOR = " ";
    private String fruit;
    private int quantity;

    public void getReport(String fromFileName, String toFileName) {
        String dataFromFile = readFromFile(fromFileName);
        String report = createReport(dataFromFile);
        writeFile(report, toFileName);
    }

    private String readFromFile(String fromFileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fromFileName))) {
            StringBuilder builder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                builder.append(value)
                        .append(" ");
                value = reader.readLine();
            }
            return builder.toString();
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + fromFileName, e);
        }
    }

    private String createReport(String dataFromFile) {
        String[] array = dataFromFile.split(DATA_BUILDER_SEPARATOR);
        Map<String, Integer> fruits = new HashMap<>();
        for (String line : array) {
            String[] splitLine = line.split(DATA_SEPARATOR);
            if (splitLine[OPERATION_POSITION].equals("b")) {
                fruit = splitLine[FRUIT_POSITION];
                quantity = Integer.parseInt(splitLine[QUANTITY_POSITION]);
                fruits.put(fruit, quantity);
            }
            if (splitLine[OPERATION_POSITION].equals("s") || splitLine[OPERATION_POSITION].equals("r")) {
                int oldQuantity = fruits.get(splitLine[FRUIT_POSITION]);
                fruits.put(splitLine[FRUIT_POSITION], oldQuantity + Integer.parseInt(splitLine[QUANTITY_POSITION]));
            }
            if (splitLine[OPERATION_POSITION].equals("p")) {
                int oldQuantity = fruits.get(splitLine[FRUIT_POSITION]);
                fruits.put(splitLine[FRUIT_POSITION], oldQuantity - Integer.parseInt(splitLine[QUANTITY_POSITION]));
            }
        }
        StringBuilder report = new StringBuilder("fruit,quantity");
        for (Map.Entry entry : fruits.entrySet()) {
            report.append(System.lineSeparator());
            report.append(entry.getKey());
            report.append(",");
            report.append(entry.getValue());
        }

        return report.toString();
    }

    private void writeFile(String report, String toFileName) {
        try {
            Files.write(Path.of(toFileName), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + toFileName, e);
        }
    }

    private void Operation(String operation) {
        switch (operation) {
            case "b":
                this.operation = Operation.BALANCE;
            case "s":
                this.operation = Operation.SUPPLY;
            case "p":
                this.operation = Operation.PURCHASE;
            case "r":
                this.operation = Operation.RETURN;
            default:
                throw new RuntimeException("невалидная операция");
        }
    }

    private enum Operation {
        BALANCE,
        SUPPLY,
        PURCHASE,
        RETURN;
    }
}