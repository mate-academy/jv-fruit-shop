package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    {
        fruitDao = new FruitDaoImpl();
    }

    @Override
    public void handle(FruitTransaction transaction) {
        Integer currentQuantity = fruitDao.getQuantity(transaction.getFruit());
        Integer newQuantity = currentQuantity + transaction.getQuantity();
        fruitDao.updateQuantity(transaction.getFruit(), newQuantity);
    }
}
