package core.basesyntax.strategy;

import java.util.HashMap;
import java.util.Map;
import model.FruitTransaction;

public class OperationStrategyProvider {
    private final Map<FruitTransaction.OperationType, OperationHandler>
            operationStrategy = new HashMap<>();

    public OperationStrategyProvider() {
        operationStrategy.put(FruitTransaction.OperationType.BALANCE,
                new BalanceOperationHandler());
        operationStrategy.put(FruitTransaction.OperationType.SUPPLY,
                new SupplyOperationHandler());
        operationStrategy.put(FruitTransaction.OperationType.PURCHASE, new
                PurchaseOperationHandler());
        operationStrategy.put(FruitTransaction.OperationType.RETURN,
                new ReturnOperationHandler());
    }

    public OperationHandler getHandler(FruitTransaction.OperationType operationType) {
        return operationStrategy.get(operationType);
    }

    public Map<FruitTransaction.OperationType, OperationHandler> getOperationStrategy() {
        return operationStrategy;
    }
}
