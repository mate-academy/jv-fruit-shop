package service.impl;

import java.util.Map;
import model.Fruit;
import service.OperationStrategy;
import service.operation.OperationHandler;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<String, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<String, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler update(Fruit fruit) {
        return operationHandlerMap.get(fruit.getOperation().trim());
    }
}
