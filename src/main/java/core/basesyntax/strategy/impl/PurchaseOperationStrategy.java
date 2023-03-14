package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;

public class PurchaseOperationStrategy extends MinusOperationStrategy {
    public PurchaseOperationStrategy(FruitDao fruitDao) {
        super(fruitDao);
    }
}
