package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;
import java.util.Objects;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> handlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> handlers) {
        this.handlers = Objects.requireNonNull(handlers);
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        OperationHandler handler = handlers.get(operation);
        if (handler == null) {
            throw new IllegalArgumentException("No handler for operation: " + operation);
        }
        return handler;
    }
}
