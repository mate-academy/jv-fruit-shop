package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationHandler;

public class QuantityAddOperationHandler implements OperationHandler {
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void operationProcess(Transaction fruitTransaction) {
        if (fruitDao.get(fruitTransaction.getProductName()) != null) {
            int value = fruitDao.get(fruitTransaction.getProductName())
                    + fruitTransaction.getQuantity();
            fruitDao.add(fruitTransaction.getProductName(), value);
        } else {
            fruitDao.add(fruitTransaction.getProductName(), fruitTransaction.getQuantity());
        }
    }
}
