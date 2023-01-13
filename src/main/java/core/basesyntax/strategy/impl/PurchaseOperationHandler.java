package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private static final int MIN_QUANTITY = 0;
    private final FruitDao fruitDao;

    {
        fruitDao = new FruitDaoImpl();
    }

    @Override
    public void handle(FruitTransaction transaction) {
        Integer currentQuantity = fruitDao.getQuantity(transaction.getFruit());
        Integer newQuantity = currentQuantity - transaction.getQuantity();
        if (newQuantity < MIN_QUANTITY) {
            throw new RuntimeException("Quantity can't be less than " + MIN_QUANTITY);
        }
        fruitDao.updateQuantity(transaction.getFruit(), newQuantity);
    }
}
