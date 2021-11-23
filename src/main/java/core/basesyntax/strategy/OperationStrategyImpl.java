package core.basesyntax.strategy;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<String, OperationHandler> handlerMap;

    public OperationStrategyImpl(Map<String, OperationHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public OperationHandler get(String operationType) {
        return handlerMap.get(operationType);
    }
}
