package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitShopService {
    private final Map<FruitTransaction.OperationType, OperationStrategy> operationsMap;

    public FruitShopService(Map<FruitTransaction.OperationType, OperationStrategy> operationsMap) {
        this.operationsMap = operationsMap;
    }

    public void processFile(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            FruitTransaction.OperationType operationType =
                    FruitTransaction.OperationType.fromCode(transaction.getOperation());
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
