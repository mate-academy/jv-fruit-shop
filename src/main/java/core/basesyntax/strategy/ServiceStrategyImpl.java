package core.basesyntax.strategy;

import core.basesyntax.strategy.operation.OperationHandler;
import java.util.Map;

public class ServiceStrategyImpl implements ServiceStrategy {
    private Map<String, OperationHandler> operationHandlerMap;

    public ServiceStrategyImpl(Map<String, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler getOperation(String operation) {
        return operationHandlerMap.get(operation);
    }
}
