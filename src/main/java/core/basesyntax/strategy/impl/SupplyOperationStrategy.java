package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;

public class SupplyOperationStrategy extends PlusOperationStrategy {
    public SupplyOperationStrategy(FruitDao fruitDao) {
        super(fruitDao);
    }
}
