package core.fruitshop.service.strategy.impl;

import core.fruitshop.model.FruitTransaction.Operation;
import core.fruitshop.service.strategy.OperationHandler;
import core.fruitshop.service.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(
            Map<Operation, OperationHandler> operationHandlerMapHandlerMap) {
        this.operationHandlerMap = operationHandlerMapHandlerMap;
    }

    @Override
    public OperationHandler getOperationHandler(Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
