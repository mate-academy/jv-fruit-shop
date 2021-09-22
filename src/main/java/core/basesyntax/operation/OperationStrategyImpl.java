package core.basesyntax.operation;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<String, OperationHandler> handlerMap;

    public OperationStrategyImpl(Map<String, OperationHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public OperationHandler get(String operation) {
        if (handlerMap.get(operation) == null) {
            throw new RuntimeException("Invalid operation");
        }
        return handlerMap.get(operation);
    }
}
