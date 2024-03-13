package core.basesyntax.service.strategy;

import core.basesyntax.model.Operation;
import java.util.HashMap;
import java.util.Map;

public class OperationProcessorImpl implements OperationProcessor {
    private final Map<Operation, OperationHandler> operationHandlers = new HashMap<>();

    public void addOperationHandler(Operation operation, OperationHandler handler) {
        operationHandlers.put(operation, handler);
    }

    public void processOperation(Operation operation) {
        OperationHandler handler = operationHandlers.get(operation);
        if (handler != null) {
            handler.calculateBalanceAfterActivities();
        }
    }
}
