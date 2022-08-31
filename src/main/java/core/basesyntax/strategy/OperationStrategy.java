package core.basesyntax.strategy;

import java.util.Map;

public class OperationStrategy {
    private final Map<String, OperationHandler> handlerMap;

    public OperationStrategy(Map<String, OperationHandler> map) {
        this.handlerMap = map;
    }

    public OperationHandler getByOperation(String operation) {
        return handlerMap.get(operation);
    }
}
