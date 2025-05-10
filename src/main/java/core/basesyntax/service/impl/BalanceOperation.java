package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;

public class BalanceOperation implements OperationStrategy {
    private final FruitDao fruitDaoImpl;

    public BalanceOperation(FruitDao fruitDaoImpl) {
        this.fruitDaoImpl = fruitDaoImpl;
    }

    @Override
    public void execute(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        fruitDaoImpl.supplyFruit(fruit, quantity);
    }
}
