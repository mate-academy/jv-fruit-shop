package core.basesyntax.strategy.transaction;

import core.basesyntax.dao.TransactionDao;

public class ReturnHandler implements TransactionHandler {
    private final TransactionDao transactionDao;

    public ReturnHandler(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    @Override
    public void doTransaction(String fruitType, int quantity) {
        int oldQuantity = transactionDao.getFruit(fruitType).getQuantity();
        transactionDao.getFruit(fruitType).setQuantity(oldQuantity + quantity);
    }
}
