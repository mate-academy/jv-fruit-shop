package strategy.impl;

import java.util.Map;
import model.FruitTransaction;
import strategy.FruitHandler;
import strategy.OperationStrategy;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, FruitHandler> operationFruitHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            FruitHandler> operationFruitHandlerMap) {
        this.operationFruitHandlerMap = operationFruitHandlerMap;
    }

    @Override
    public FruitHandler get(FruitTransaction.Operation operation) {
        return operationFruitHandlerMap.get(operation);
    }
}
