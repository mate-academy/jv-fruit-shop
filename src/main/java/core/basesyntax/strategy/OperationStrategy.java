package core.basesyntax.strategy;

import java.util.Map;

public class OperationStrategy {
    private final Map<String, OperationHandler> handlerMap;

    public OperationStrategy(Map<String, OperationHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public OperationHandler getByOperation(String operation) {
        return handlerMap.get(operation);
    }
}
