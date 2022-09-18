package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operations.OperationsStrategyImpl;

import java.util.List;

public class ShopServiceImpl implements ShopService{
    OperationsStrategyImpl operationsStrategy;

    public ShopServiceImpl(OperationsStrategyImpl operationsStrategy) {
        this.operationsStrategy = operationsStrategy;
    }

    @Override
    public void transaction(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.forEach(i ->operationsStrategy.doOperation(i));
    }
}

