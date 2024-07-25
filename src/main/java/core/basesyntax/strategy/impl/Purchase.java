package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class Purchase implements OperationHandler {
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void apply(FruitTransaction transaction) {
        int quantity = fruitDao.get(transaction.fruit());
        if (quantity < transaction.quantity()) {
            throw new RuntimeException("Not enough quantity");
        }
        fruitDao.add(transaction.fruit(), quantity
                - transaction.quantity());
    }
}
