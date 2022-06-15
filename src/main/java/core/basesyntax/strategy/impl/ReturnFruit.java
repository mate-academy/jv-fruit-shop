package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnFruit implements OperationHandler {
    FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void makeOperation(FruitTransaction transactions) {
        Integer currentQuantity = fruitDao.getFruitQuantity(transactions.getFruit());
        currentQuantity += transactions.getQuantity();
        fruitDao.update(transactions.getFruit(), currentQuantity);
    }
}
