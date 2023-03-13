package core.basesyntax.strategy;

import core.basesyntax.handlers.OperationHandler;
import java.util.Map;

public class StrategyImpl implements Strategy {
    private Map<String, OperationHandler> operationHandlerMap;

    public StrategyImpl(Map<String, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(String operation) {
        return operationHandlerMap.get(operation);
    }
}
