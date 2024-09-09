package core.basesyntax.strategy.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<Operation, OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    public void applyOperation(Operation operation, String fruit,
                               int quantity, Map<String, Integer> storage) {
        operationHandlers.get(operation).apply(fruit, quantity, storage);
    }
}
