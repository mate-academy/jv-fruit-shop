package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationType;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationType> operationHandlersMap;

    public OperationStrategyImpl(
            Map<FruitTransaction.Operation, OperationType> operationHandlersMap) {
        this.operationHandlersMap = operationHandlersMap;
    }

    @Override
    public OperationType operationHandler(FruitTransaction.Operation operationKey) {
        return operationHandlersMap.get(operationKey);
    }
}
