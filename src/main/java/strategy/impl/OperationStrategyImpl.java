package strategy.impl;

import handler.OperationHandler;
import java.util.Map;
import model.FruitTransaction;
import strategy.OperationStrategy;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> handlerOperationMap;

    public OperationStrategyImpl(
            Map<FruitTransaction.Operation, OperationHandler> handlerOperationMap) {
        this.handlerOperationMap = handlerOperationMap;
    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        return handlerOperationMap.get(operation);
    }
}
