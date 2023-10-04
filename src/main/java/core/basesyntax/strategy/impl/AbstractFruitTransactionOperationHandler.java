package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.strategy.FruitTransactionOperationHandler;

public abstract class AbstractFruitTransactionOperationHandler
        implements FruitTransactionOperationHandler {
    protected final FruitDao fruitDao;

    protected AbstractFruitTransactionOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }
}
