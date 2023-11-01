package core.basesyntax.strategy;

import core.basesyntax.model.GoodsOperation;
import java.util.Map;

public class OperationsStrategy {
    private final Map<GoodsOperation.TransactionType, OperationHandler> strategies;

    public OperationsStrategy(Map<GoodsOperation.TransactionType, OperationHandler> strategies) {
        this.strategies = strategies;
    }

    public void handleOperation(GoodsOperation operation) {
        for (Map.Entry<GoodsOperation.TransactionType, OperationHandler> strategy
                : strategies.entrySet()) {
            if (strategy.getKey().equals(operation.getOperationType())) {
                strategy.getValue().handleOperation(operation);
            }
        }
    }
}
