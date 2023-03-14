package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;

public class ReturnOperationStrategy extends PlusOperationStrategy {
    public ReturnOperationStrategy(FruitDao fruitDao) {
        super(fruitDao);
    }
}
