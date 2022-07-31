package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.operation.OperationType;
import java.util.Map;

public class OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationType> operationMap;

    public OperationStrategy(Map<FruitTransaction.Operation,
            OperationType> operationMap) {
        this.operationMap = operationMap;
    }

    public OperationType getOperationType(FruitTransaction.Operation operation) {
        return operationMap.get(operation);
    }
}
