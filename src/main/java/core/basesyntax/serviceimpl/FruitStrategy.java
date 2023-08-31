package core.basesyntax.serviceimpl;

import core.basesyntax.service.OperationHandler;
import java.util.Map;

public class FruitStrategy {
    private final Map<String, OperationHandler> operationHandlers;

    public FruitStrategy(Map<String, OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    public OperationHandler getOperationService(String type) {
        return operationHandlers.get(type);
    }
}
