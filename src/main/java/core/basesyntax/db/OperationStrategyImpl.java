package core.basesyntax.db;

import core.basesyntax.model.OperationType;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<OperationType, OperationHandler> operationStrategyMap;

    public OperationStrategyImpl(Map<OperationType, OperationHandler> operationStrategyMap) {
        this.operationStrategyMap = operationStrategyMap;
    }

    @Override
    public OperationHandler get(OperationType type) {
        return operationStrategyMap.get(type);
    }
}
