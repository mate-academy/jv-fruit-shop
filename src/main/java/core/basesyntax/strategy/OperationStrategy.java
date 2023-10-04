package core.basesyntax.strategy;

import core.basesyntax.model.fruit.Operation;
import java.util.Map;

public class OperationStrategy {
    private final Map<Operation, OperationHandler> operationHandlerMap;

    public OperationStrategy(Map<Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    public OperationHandler get(Operation type) {
        return operationHandlerMap.get(type);
    }
}
