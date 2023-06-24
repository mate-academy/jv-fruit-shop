package core.basesyntax.strategy.transaction;

import core.basesyntax.dao.TransactionDao;
import core.basesyntax.model.Fruit;

public class BalanceHandler implements TransactionHandler {
    private final TransactionDao transactionDao;

    public BalanceHandler(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    @Override
    public void doTransaction(String fruitType, int quantity) {
        Fruit fruit = new Fruit(fruitType, quantity);
        transactionDao.addFruit(fruit);
    }
}
