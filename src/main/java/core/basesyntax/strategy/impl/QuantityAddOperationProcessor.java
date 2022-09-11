package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationProcessor;

public class QuantityAddOperationProcessor implements OperationProcessor {
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void processOperation(Transaction fruitTransaction) {
        if (fruitDao.get(fruitTransaction.getProductName()) != null) {
            int value = fruitDao.get(fruitTransaction.getProductName())
                    + fruitTransaction.getQuantity();
            fruitDao.add(fruitTransaction.getProductName(), value);
        } else {
            fruitDao.add(fruitTransaction.getProductName(), fruitTransaction.getQuantity());
        }
    }
}
