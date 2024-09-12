package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.operationhandler.OperationHandler;
import java.util.Map;

public class OperationStrategy {
    private Map<Operation, OperationHandler> operationHandlerMap;

    public OperationStrategy(Map<Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    public OperationHandler getHandler(Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
