package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class Purchase implements OperationHandler {
    FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void makeOperation(FruitTransaction transaction) {
        int currentQuantity = fruitDao.getFruitQuantity(transaction.getFruit());
        if (transaction.getQuantity() > currentQuantity) {
            throw new RuntimeException("There are not enough " +
                    transaction.getFruit() + " in shop. There only " + currentQuantity);
        }
        currentQuantity -= transaction.getQuantity();
        fruitDao.update(transaction.getFruit(), currentQuantity);
    }
}
