package core.strategy;

import core.strategy.handlers.OperationHandler;
import java.util.Map;

public class OperationHandlerStrategyImpl implements OperationHandlerStrategy {
    private final Map<String, OperationHandler> operationsHandlerMap;

    public OperationHandlerStrategyImpl(Map<String, OperationHandler> operationsHandlerMap) {
        this.operationsHandlerMap = operationsHandlerMap;
    }

    @Override
    public OperationHandler get(String operation) {
        return operationsHandlerMap.get(operation);
    }
}
