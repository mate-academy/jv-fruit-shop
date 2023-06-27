package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class ReturnFruitTransactionOperationHandler
        extends AbstractFruitTransactionOperationHandler {
    public ReturnFruitTransactionOperationHandler(FruitDao fruitDao) {
        super(fruitDao);
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitDao.updateQuantity(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
