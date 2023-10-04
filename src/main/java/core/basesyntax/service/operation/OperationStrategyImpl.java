package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.OperationType, OperationHandler> operationMap;

    public OperationStrategyImpl(Map<FruitTransaction.OperationType,
            OperationHandler> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public OperationHandler getOperation(FruitTransaction.OperationType operationType) {
        return operationMap.get(operationType);
    }
}
