package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import strategy.OperationStrategy;

public class FruitShopService {
    private static final String COMMA = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String REPORT_HEADER = "fruit,quantity";

    private final FileReaderService fileReaderService;
    private final OperationStrategy strategyFactory;
    private final FileWriterService fileWriterService;
    private final StorageService storageService;

    public FruitShopService(FileReaderService fileReaderService,
                            OperationStrategy strategyFactory,
                            FileWriterService fileWriterService,
                            StorageService storageService) {
        this.fileReaderService = fileReaderService;
        this.strategyFactory = strategyFactory;
        this.fileWriterService = fileWriterService;
        this.storageService = storageService;
    }

    public void processTransactionsAndGenerateReport(String inputFilePath, String outputFilePath) {
        List<String> lines = fileReaderService.readFromFile(inputFilePath);
        storageService.clearStorage();

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
                    .execute(fruit, quantity, storageService);
        }

        List<String> report = generateReport();
        fileWriterService.writeToFile(report, outputFilePath);
    }

    private List<String> generateReport() {
        List<String> report = new ArrayList<>();
        report.add(REPORT_HEADER);
        Map<String, Integer> fruitQuantities = storageService.getFruitQuantities();
        for (Map.Entry<String, Integer> entry : fruitQuantities.entrySet()) {
            report.add(entry.getKey() + COMMA + entry.getValue());
        }
        return report;
    }
}
