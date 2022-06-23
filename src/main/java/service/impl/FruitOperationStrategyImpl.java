package service.impl;

import java.util.Map;
import model.FruitTransaction;
import service.FruitOperationStrategy;
import strategy.FruitsAmountHandler;

public class FruitOperationStrategyImpl implements FruitOperationStrategy {
    private Map<FruitTransaction.Operation, FruitsAmountHandler> amountHandlerMap;

    public FruitOperationStrategyImpl(Map<FruitTransaction.Operation,
            FruitsAmountHandler> amountHandlerMap) {
        this.amountHandlerMap = amountHandlerMap;
    }

    @Override
    public FruitsAmountHandler get(FruitTransaction.Operation operation) {
        return amountHandlerMap.get(operation);
    }
}
