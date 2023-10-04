package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class PurchaseFruitTransactionOperationHandler
        extends AbstractFruitTransactionOperationHandler {
    public PurchaseFruitTransactionOperationHandler(FruitDao fruitDao) {
        super(fruitDao);
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitDao.subtractQuantity(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
