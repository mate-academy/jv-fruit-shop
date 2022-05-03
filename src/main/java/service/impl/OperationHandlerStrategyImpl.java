package service.impl;

import java.util.Map;
import model.FruitTransaction;
import service.OperationHandlerStrategy;
import service.strategy.OperationHandler;

public class OperationHandlerStrategyImpl implements OperationHandlerStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> map;

    public OperationHandlerStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> map) {
        this.map = map;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return map.get(operation);
    }
}
