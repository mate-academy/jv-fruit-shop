package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public PurchaseOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        Integer currentBalance = fruitDao.getQuantity(transaction.getFruit());

        if (currentBalance == null || currentBalance < transaction.getQuantity()) {
            throw new RuntimeException("Balance can't be negative");
        }

        fruitDao.add(transaction.getFruit(), -transaction.getQuantity());

    }

}
