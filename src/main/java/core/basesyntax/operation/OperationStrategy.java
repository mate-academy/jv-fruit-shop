package core.basesyntax.operation;

import core.basesyntax.model.OperationType;
import java.util.Map;

public class OperationStrategy {
    private final Map<OperationType, OperationHandler> operationHandlerMap;

    public OperationStrategy(Map<OperationType, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    public OperationHandler getOperationHandler(OperationType type) {
        return operationHandlerMap.get(type);
    }
}
