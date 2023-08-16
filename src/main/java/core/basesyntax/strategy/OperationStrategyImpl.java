package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandle;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandle> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandle> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandle get(FruitTransaction.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
