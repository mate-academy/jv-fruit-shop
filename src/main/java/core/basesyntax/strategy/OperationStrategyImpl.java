package core.basesyntax.strategy;

import core.basesyntax.handler.OperationHandler;
import core.basesyntax.model.OperationType;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<OperationType, OperationHandler> operationStrategyMap;

    public OperationStrategyImpl(Map<OperationType, OperationHandler> operationStrategyMap) {
        this.operationStrategyMap = operationStrategyMap;
    }

    @Override
    public OperationHandler getHandler(OperationType operationType) {
        return operationStrategyMap.get(operationType);
    }
}
