package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class FruitShopService {

    private final FileReader fileReader;
    private final DataConverter dataConverter;
    private final Map<FruitTransaction.OperationType, OperationStrategy> operationsMap;

    public FruitShopService(
            FileReader fileReader,
            DataConverter dataConverter,
            Map<FruitTransaction.OperationType, OperationStrategy> operationsMap) {
        this.fileReader = fileReader;
        this.dataConverter = dataConverter;
        this.operationsMap = operationsMap;
    }

    public void processFile(String inputFilePath) throws IOException {
        List<String> data = fileReader.processFile(inputFilePath);

        List<FruitTransaction> transactions = dataConverter.convertDataToTransactions(data);

        for (FruitTransaction transaction : transactions) {
            FruitTransaction.OperationType operationType
                    = FruitTransaction.OperationType.fromCode(transaction.getOperation());
            String fruit = transaction.getFruit();
            int quantity = transaction.getQuantity();

            OperationStrategy operationStrategy = operationsMap.get(operationType);

            if (operationStrategy != null && operationStrategy.isValid(fruit, quantity)) {
                operationStrategy.execute(fruit, quantity);
            } else {
                throw new RuntimeException("Invalid or unknown operation: " + operationType);
            }
        }
    }
}
