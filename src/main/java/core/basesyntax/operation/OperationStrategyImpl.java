package core.basesyntax.operation;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<String, Handler> handlerMap;

    public OperationStrategyImpl(Map<String, Handler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public Handler getHandel(String operation) {
        if (handlerMap.get(operation) == null) {
            throw new RuntimeException("Invalid operation");
        }
        return handlerMap.get(operation);
    }
}
