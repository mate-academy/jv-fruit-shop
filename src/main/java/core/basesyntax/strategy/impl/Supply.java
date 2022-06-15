package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class Supply implements OperationHandler {
    FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void makeOperation(FruitTransaction transaction) {
        int currentQuantity = fruitDao.getFruitQuantity(transaction.getFruit());
        currentQuantity += transaction.getQuantity();
        fruitDao.update(transaction.getFruit(), currentQuantity);
    }
}
