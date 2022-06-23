package service.impl;

import java.util.Map;
import model.FruitTransaction;
import service.FruitsAmountStrategy;
import strategy.FruitsAmountHandler;

public class FruitsAmountStrategyImpl implements FruitsAmountStrategy {
    private Map<FruitTransaction.Operation, FruitsAmountHandler> amountHandlerMap;

    public FruitsAmountStrategyImpl(Map<FruitTransaction.Operation,
            FruitsAmountHandler> amountHandlerMap) {
        this.amountHandlerMap = amountHandlerMap;
    }

    @Override
    public FruitsAmountHandler get(FruitTransaction.Operation operation) {
        return amountHandlerMap.get(operation);
    }
}
