package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private FruitDao fruitDao;

    public PurchaseOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        int oldQuantity = fruitDao.get(transaction.getFruit());

        if (oldQuantity < transaction.getQuantity()) {
            throw new RuntimeException("Not enough " + transaction.getFruit() + " for purchase!");
        }

        fruitDao.add(transaction.getFruit(), oldQuantity - transaction.getQuantity());
    }
}
