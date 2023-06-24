package core.basesyntax.strategy.transaction;

import core.basesyntax.dao.TransactionDao;

public class PurchaseHandler implements TransactionHandler {
    private final TransactionDao transactionDao;

    public PurchaseHandler(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    @Override
    public void doTransaction(String fruitType, int quantity) {
        int oldQuantity = transactionDao.getFruit(fruitType).getQuantity();
        transactionDao.getFruit(fruitType).setQuantity(oldQuantity - quantity);
    }
}
