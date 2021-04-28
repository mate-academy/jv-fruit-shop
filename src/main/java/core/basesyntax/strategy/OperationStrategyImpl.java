package core.basesyntax.strategy;

import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.model.operations.Operation;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<String, OperationHandler> operationHandler;

    public OperationStrategyImpl(Map<String, OperationHandler> operationHandler) {
        this.operationHandler = operationHandler;
    }

    @Override
    public OperationHandler getHandler(Operation operation) {
        return operationHandler.get(operation.getOperation());
    }
}
