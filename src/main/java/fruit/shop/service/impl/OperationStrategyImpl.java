package fruit.shop.service.impl;

import fruit.shop.strategy.OperationHandler;
import fruit.shop.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<String, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<String, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(String type) {
        return operationHandlerMap.get(type);
    }
}
