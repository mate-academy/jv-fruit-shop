package main;

import core.basesyntax.db.Storage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FileReaderService;
import service.FileWriterService;
import strategy.OperationStrategyFactory;

public class Main {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String COMMA = ",";

    public static void main(String[] args) {
        String inputFilePath = "src/main/java/resourses/input.csv";
        String outputFilePath = "src/main/java/resourses/output.csv";

        FileReaderService fileReaderService = new FileReaderService();
        List<String> lines = fileReaderService.readFromFile(inputFilePath);

        Storage storage = new Storage();
        OperationStrategyFactory strategyFactory = new OperationStrategyFactory();

        boolean isFirstLine = true;
        for (String line : lines) {
            if (isFirstLine) {
                isFirstLine = false;
                continue;
            }
            String[] parts = line.split(COMMA);
            FruitTransaction.Operation operation = FruitTransaction.Operation
                    .valueOfCode(parts[OPERATION_INDEX].trim());
            String fruit = parts[FRUIT_INDEX];
            int quantity = Integer.parseInt(parts[QUANTITY_INDEX]);

            strategyFactory.getStrategy(operation)
                    .execute(fruit, quantity, storage.getFruitQuantities());
        }

        FileWriterService fileWriterService = new FileWriterService();
        fileWriterService.writeToFile(generateReport(storage.getFruitQuantities()), outputFilePath);
    }

    private static List<String> generateReport(Map<String, Integer> fruitQuantities) {
        List<String> report = new ArrayList<>();
        report.add(REPORT_HEADER);
        for (Map.Entry<String, Integer> entry : fruitQuantities.entrySet()) {
            report.add(entry.getKey() + COMMA + entry.getValue());
        }
        return report;
    }
}
