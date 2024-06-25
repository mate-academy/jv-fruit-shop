package core.basesyntax.strategy.impl;

import java.util.Map;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> operationHandler;

    public OperationStrategyImpl(Map<Operation, OperationHandler> operationHandler) {
        this.operationHandler = operationHandler;
    }

    @Override
    public OperationHandler get(Operation operation) {
        return operationHandler.get(operation);
    }
}
