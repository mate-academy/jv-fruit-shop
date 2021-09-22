package core.basesyntax.operationstrategy;

import core.basesyntax.model.OperationType;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<OperationType, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<OperationType, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(OperationType type) {
        return operationHandlerMap.get(type);
    }
}
