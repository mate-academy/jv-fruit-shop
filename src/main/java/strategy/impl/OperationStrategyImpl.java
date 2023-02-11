package strategy.impl;

import fruitscontent.FruitsContent;
import java.util.Map;
import strategy.OperationHandler;
import strategy.OperationStrategy;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitsContent.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitsContent.Operation,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(FruitsContent.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
