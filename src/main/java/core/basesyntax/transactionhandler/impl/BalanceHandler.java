package core.basesyntax.transactionhandler.impl;

import core.basesyntax.dao.Dao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.transactionhandler.TransactionHandler;

public class BalanceHandler implements TransactionHandler {
    private final Dao dao;

    public BalanceHandler(Dao dao) {
        this.dao = dao;
    }

    @Override
    public void handleTransaction(FruitTransaction transaction) {
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("The amount of fruit in stock must be positive");
        }
        dao.add(transaction.getFruit(), transaction.getQuantity());
    }
}
