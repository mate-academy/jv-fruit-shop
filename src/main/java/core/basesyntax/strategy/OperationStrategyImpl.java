package core.basesyntax.strategy;

import core.basesyntax.operation.Operation;
import core.basesyntax.service.activity.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> activityServiceMap;

    public OperationStrategyImpl(Map<Operation, OperationHandler> activityServiceMap) {
        this.activityServiceMap = activityServiceMap;
    }

    @Override
    public OperationHandler get(Operation operation) {
        return activityServiceMap.get(operation);
    }
}
