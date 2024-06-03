package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitOperationStrategy;

public class BalanceOperationStrategy implements FruitOperationStrategy {
    private final FruitDao fruitDao;

    public BalanceOperationStrategy(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        fruitDao.addFruit(transaction.getFruitName(), transaction.getQuantity());
    }
}
