package core.basesyntax.strategy;

import core.basesyntax.service.operationwithfruits.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<String, OperationHandler> operationHandlersMap;

    public OperationStrategyImpl(Map<String, OperationHandler> operationHandlersMap) {
        this.operationHandlersMap = operationHandlersMap;
    }

    @Override
    public OperationHandler get(String operator) {
        return operationHandlersMap.get(operator);
    }
}
