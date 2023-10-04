package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceFruitTransactionOperationHandler
        extends AbstractFruitTransactionOperationHandler {
    public BalanceFruitTransactionOperationHandler(FruitDao fruitDao) {
        super(fruitDao);
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitDao.setQuantity(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
