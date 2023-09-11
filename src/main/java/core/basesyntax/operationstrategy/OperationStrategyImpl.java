package core.basesyntax.operationstrategy;

import core.basesyntax.operationstrategy.operation.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Character, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<Character, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(Character type) {
        OperationHandler handler = operationHandlerMap.get(type);
        if (handler != null) {
            return handler;
        }
        throw new RuntimeException("Incorrect operation type: " + type);
    }
}
