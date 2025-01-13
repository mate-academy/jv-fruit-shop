package core.basesyntax.operation;

import core.basesyntax.model.Operation;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {

    private final Map<Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<Operation, OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public OperationHandler getOperationHandler(Operation operation) {
        return operationHandlers.get(operation);
    }
}
