package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;
import java.util.Objects;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlers) {
        this.operationHandlers = Objects
                .requireNonNull(operationHandlers, "Operation handlers map cannot be null");
    }

    @Override
    public OperationHandler getOperationHandler(FruitTransaction.Operation operation) {
        Objects.requireNonNull(operation, "Operation cannot be null");
        OperationHandler handler = operationHandlers.get(operation);
        if (handler == null) {
            throw new IllegalArgumentException("Unknown operation: " + operation);
        }
        return handler;
    }
}
