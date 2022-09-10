package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void operationProcess(Transaction fruitTransaction) {
        int value = fruitDao.get(fruitTransaction.getProductName())
                - fruitTransaction.getQuantity();
        if (value < 0) {
            throw new RuntimeException("You don't have enough "
                    + fruitTransaction.getProductName());
        }
        fruitDao.add(fruitTransaction.getProductName(), value);
    }
}
