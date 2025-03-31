package core.basesyntax.service;

import core.basesyntax.db.FruitShopInventory;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class FruitShopService {
    private final FileReaderImpl fileProcessor = new FileReaderImpl();
    private final ReportWriter reportWriter = new ReportWriter();
    private final FruitShopInventory inventory = new FruitShopInventory();
    private final DataConverter dataConverter = new DataConverter();

    private Map<String, OperationStrategy> operationsMap;

    public FruitShopService(Map<String, OperationStrategy> operationsMap) {
        this.operationsMap = operationsMap;
    }

    public void processFile(String inputFile) throws IOException {
        List<String[]> data = FileReaderImpl.processFile(inputFile);

        List<FruitTransaction> transactions = dataConverter.convertDataToTransactions(data);

        for (FruitTransaction transaction : transactions) {
            String operation = transaction.getOperation();
            String fruit = transaction.getFruit();
            int quantity = transaction.getQuantity();

            OperationStrategy operationStrategy = operationsMap.get(operation);

            if (operationStrategy != null) {
                inventory.applyOperation(operationStrategy, fruit, quantity);
            } else {
                throw new RuntimeException("Unknown operation: " + operation);
            }
        }
    }

    public void generateAndWriteReport(String outputFile) throws IOException {
        reportWriter.writeReport(outputFile);

    }
}
