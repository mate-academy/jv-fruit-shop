package core.basesyntax.service;

import core.basesyntax.db.FruitShopInventory;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class FruitShopService {

    private final ReportWriter reportWriter = new ReportWriter();
    private final FruitShopInventory inventory = new FruitShopInventory();
    private final DataConverter dataConverter = new DataConverter();
    private final Map<FruitTransaction.OperationType, OperationStrategy> operationsMap;

    public FruitShopService(Map<FruitTransaction.OperationType, OperationStrategy> operationsMap) {
        this.operationsMap = operationsMap;
    }

    public void processFile(String inputFilePath) throws IOException {
        List<String[]> data = FileReaderImpl.processFile(inputFilePath);

        List<FruitTransaction> transactions = dataConverter.convertDataToTransactions(data);

        for (FruitTransaction transaction : transactions) {
            FruitTransaction.OperationType operationType
                    = FruitTransaction.OperationType.fromCode(transaction.getOperation());
            String fruit = transaction.getFruit();
            int quantity = transaction.getQuantity();

            OperationStrategy operationStrategy = operationsMap.get(operationType);

            if (operationStrategy != null) {
                inventory.applyOperation(operationStrategy, fruit, quantity);
            } else {
                throw new RuntimeException("Unknown operation: " + operationType);
            }
        }
    }

    public void generateAndWriteReport(String outputFilePath) throws IOException {
        reportWriter.writeReport(outputFilePath);
    }
}
