package core.basesyntax.strategy.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> operations;

    public OperationStrategyImpl(Map<Operation, OperationHandler> operations) {
        this.operations = operations;
    }

    @Override
    public OperationHandler operationHandler(Operation operation) {
        return operations.get(operation);
    }
}
