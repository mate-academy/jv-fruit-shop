package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.operations.OperationHandler;
import java.util.Map;
import java.util.Objects;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationOperationHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationOperationHandlerMap) {
        this.operationOperationHandlerMap = operationOperationHandlerMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        Objects.requireNonNull(operation, "Operation cannot be null");
        OperationHandler operationHandler = operationOperationHandlerMap.get(operation);
        if (operationHandler == null) {
            throw new IllegalArgumentException("Unknown operation: " + operation);
        }
        return operationHandler;
    }
}
