package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.operation.OperationHandler;
import java.util.Map;

public class OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationMap;

    public OperationStrategy(Map<FruitTransaction.Operation,
            OperationHandler> operationMap) {
        this.operationMap = operationMap;
    }

    public OperationHandler getOperationType(FruitTransaction.Operation operation) {
        return operationMap.get(operation);
    }
}
