package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.operation.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {

    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlersMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlersMap) {
        this.operationHandlersMap = operationHandlersMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        if (operationHandlersMap.containsKey(operation)) {
            return operationHandlersMap.get(operation);
        }
        throw new RuntimeException("Operation " + operation + " not supported");
    }
}
