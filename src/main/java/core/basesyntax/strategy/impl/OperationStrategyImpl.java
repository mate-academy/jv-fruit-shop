package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<Operation, OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public void applyOperation(Operation operation, String fruit,
                               int quantity, Storage storage) {
        OperationHandler handler = operationHandlers.get(operation);

        if (handler == null) {
            throw new IllegalArgumentException("Operation not supported: " + operation);
        }

        handler.apply(fruit, quantity, storage);
    }

}
