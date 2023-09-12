package core.basesyntax.operationstrategy;

import core.basesyntax.operationstrategy.operation.OperationHandler;
import core.basesyntax.operationstrategy.operation.OperationType;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<OperationType, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<OperationType, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(OperationType type) {
        OperationHandler handler = operationHandlerMap.get(type);
        if (handler != null) {
            return handler;
        }
        throw new RuntimeException("Incorrect operation type: " + type);
    }
}
