package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceHandlerImpl implements OperationHandler {
    private final FruitDao fruitDao;

    public BalanceHandlerImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void applyChanges(Transaction transaction) {
        int remaining =
                fruitDao.getQuantity(transaction.getNameFruit()) == null
                ? 0 : fruitDao.getQuantity(transaction.getNameFruit());
        int newQuantity = transaction.getAmount() + remaining;
        fruitDao.update(transaction.getNameFruit(), newQuantity);
    }
}
