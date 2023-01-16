package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public Integer getNewQuantityForFruit(FruitTransaction fruitTransaction) {
        FruitDao fruitDao = new FruitDaoImpl();

        Integer currentQuantity = fruitDao.getQuantity(fruitTransaction.getName());
        return fruitTransaction.getQuantity() + ((currentQuantity == null) ? 0 : currentQuantity);
    }
}
