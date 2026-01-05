package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import java.util.Map;

public class StrategyImpl implements Strategy {
    private final Map<Operation, OperationHandler> operationHandlerMap;

    public StrategyImpl(Map<Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler getOperationHandler(Operation operation) {
        OperationHandler operationHandler = operationHandlerMap.get(operation);
        if (operationHandler == null) {
            throw new RuntimeException("No handler registered for operation: " + operation);
        }
        return operationHandler;
    }
}
