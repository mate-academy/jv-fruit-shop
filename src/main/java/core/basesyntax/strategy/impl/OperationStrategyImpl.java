package core.basesyntax.strategy.impl;

import core.basesyntax.model.transaction.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.handler.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {

    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(
            Map<FruitTransaction.Operation, OperationHandler> operationHandlers) {
        if (operationHandlers == null) {
            throw new IllegalArgumentException("Operation handlers map can't be null");
        }
        this.operationHandlers = Map.copyOf(operationHandlers);
    }

    @Override
    public OperationHandler getOperationHandler(FruitTransaction.Operation operation) {
        if (operationHandlers == null) {
            throw new IllegalArgumentException("Operation handlers map can't be null");
        }
        OperationHandler handler = operationHandlers.get(operation);
        if (handler == null) {
            throw new IllegalArgumentException("No handler for operation: " + operation);
        }
        return handler;
    }
}
