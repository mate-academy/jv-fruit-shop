package core.basesyntax.service.strategy;

import core.basesyntax.model.Operations;
import java.util.Map;

public class OperationsStrategyImpl implements OperationsStrategy {
    private final Map<Operations, OperationHandler> operationsHandlerMap;

    public OperationsStrategyImpl(Map<Operations, OperationHandler> operationsHandlerMap) {
        this.operationsHandlerMap = operationsHandlerMap;
    }

    @Override
    public OperationHandler get(Operations operation) {
        if (!operationsHandlerMap.containsKey(operation)) {
            throw new UnsupportedOperationException("Operation " + operation + " is not supported");
        }
        return operationsHandlerMap.get(operation);
    }
}
