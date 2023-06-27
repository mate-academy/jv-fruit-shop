package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class SupplyFruitTransactionOperationHandler
        extends AbstractFruitTransactionOperationHandler {
    public SupplyFruitTransactionOperationHandler(FruitDao fruitDao) {
        super(fruitDao);
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitDao.updateQuantity(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
