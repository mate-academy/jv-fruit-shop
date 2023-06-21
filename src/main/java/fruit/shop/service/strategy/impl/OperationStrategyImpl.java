package fruit.shop.service.strategy.impl;

import fruit.shop.model.FruitTransaction;
import fruit.shop.service.strategy.OperationHandler;
import fruit.shop.service.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> fruitMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> fruitMap) {
        this.fruitMap = fruitMap;
    }

    @Override
    public OperationHandler getOperationHandler(FruitTransaction transaction) {
        return fruitMap.get(transaction.getOperation());
    }
}
