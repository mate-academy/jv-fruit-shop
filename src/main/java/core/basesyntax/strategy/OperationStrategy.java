package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import java.util.Map;

public class OperationStrategy {
    private final Map<Operation, OperationHandler> operationHandler;

    public OperationStrategy(
            Map<Operation, OperationHandler> operationHandler) {
        this.operationHandler = operationHandler;
    }

    public OperationHandler getHandler(Operation operation) {
        return operationHandler.get(operation);
    }
}
