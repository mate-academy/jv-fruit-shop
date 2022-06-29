package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnHandlerImpl implements OperationHandler {
    private final FruitDao fruitDao;

    public ReturnHandlerImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void applyChanges(Transaction transaction) {
        int remaining = fruitDao.getQuantity(transaction.getNameFruit());
        int newQuantity = transaction.getAmount() + remaining;
        fruitDao.update(transaction.getNameFruit(), newQuantity);
    }
}
