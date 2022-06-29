package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseHandlerImpl implements OperationHandler {
    private final FruitDao fruitDao;

    public PurchaseHandlerImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void applyChanges(Transaction transaction) {
        int remaining = fruitDao.getQuantity(transaction.getNameFruit());
        int newQuantity = remaining - transaction.getAmount();
        fruitDao.update(transaction.getNameFruit(), newQuantity);
    }
}
