package core.basesyntax.strategy;

import core.basesyntax.service.OperationHandler;
import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private final Map<String, OperationHandler> operationHandlerMap;

    public TransactionStrategyImpl(Map<String, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(String key) {
        return operationHandlerMap.get(key);
    }
}
