package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operations.OperationsStrategyImpl;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationsStrategyImpl operationsStrategy;

    public ShopServiceImpl(OperationsStrategyImpl operationsStrategy) {
        this.operationsStrategy = operationsStrategy;
    }

    @Override
    public void transaction(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.forEach(operationsStrategy::doOperation);
    }
}

