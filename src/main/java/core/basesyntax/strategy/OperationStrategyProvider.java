package core.basesyntax.strategy;

import exception.OperationException;
import java.util.HashMap;
import java.util.Map;
import model.FruitTransaction;

public class OperationStrategyProvider {
    private final Map<FruitTransaction.OperationType, OperationHandler> operationStrategy =
            new HashMap<>();

    public OperationStrategyProvider() {
        operationStrategy.put(FruitTransaction.OperationType.BALANCE,
                new BalanceOperationHandler());
        operationStrategy.put(FruitTransaction.OperationType.SUPPLY,
                new SupplyOperationHandler());
        operationStrategy.put(FruitTransaction.OperationType.PURCHASE,
                new PurchaseOperationHandler());
        operationStrategy.put(FruitTransaction.OperationType.RETURN,
                new ReturnOperationHandler());
    }

    public OperationHandler getHandler(FruitTransaction.OperationType operationType) {
        OperationHandler handler = operationStrategy.get(operationType);
        if (handler == null) {
            throw new OperationException("Unknown operation type: " + operationType);
        }
        return handler;
    }

    public Map<FruitTransaction.OperationType, OperationHandler> getOperationStrategy() {
        return operationStrategy;
    }
}
