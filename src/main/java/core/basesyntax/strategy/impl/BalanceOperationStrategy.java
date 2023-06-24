package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;

public class BalanceOperationStrategy extends PlusOperationStrategy {
    public BalanceOperationStrategy(FruitDao fruitDao) {
        super(fruitDao);
    }
}
