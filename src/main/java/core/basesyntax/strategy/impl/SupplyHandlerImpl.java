package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyHandlerImpl implements OperationHandler {
    private final FruitDao fruitDao;

    public SupplyHandlerImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void applyChanges(Transaction transaction) {
        if (transaction.getAmount() < 0) {
            throw new RuntimeException("Supply cannot be less than 0");
        }
        int remainingFruits = fruitDao.getQuantity(transaction.getNameFruit()) == null
                ? 0 : fruitDao.getQuantity(transaction.getNameFruit());
        int newQuantity = transaction.getAmount() + remainingFruits;
        fruitDao.update(transaction.getNameFruit(), newQuantity);
    }
}
