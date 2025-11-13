package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<Operation, OperationHandler> operationHandlers) {
        if (operationHandlers == null) {
            throw new IllegalArgumentException("Operation handlers map cannot be null");
        }
        this.operationHandlers = operationHandlers;
    }

    @Override
    public OperationHandler get(Operation operation) {
        return operationHandlers.get(operation);
    }
}
