package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    private FruitDao fruitDao;

    {
        fruitDao = new FruitDaoImpl();
    }

    @Override
    public void handle(FruitTransaction transaction) {
        fruitDao = new FruitDaoImpl();
        Integer currentQuantity = fruitDao.getQuantity(transaction.getFruit());
        Integer newQuantity = currentQuantity + transaction.getQuantity();
        fruitDao.updateData(transaction.getFruit(), newQuantity);
    }
}
