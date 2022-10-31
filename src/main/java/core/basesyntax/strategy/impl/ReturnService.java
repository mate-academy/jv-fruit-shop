package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class ReturnService implements OperationHandler {
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void operationWithFruitTransaction(FruitTransaction fruitTransaction) {
        fruitDao.get(fruitTransaction.getFruit())
                        .ifPresent(f -> f.setQuantity(f.getQuantity()
                                + fruitTransaction.getQuantity()));
    }
}
