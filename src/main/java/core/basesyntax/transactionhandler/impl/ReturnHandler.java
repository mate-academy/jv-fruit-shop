package core.basesyntax.transactionhandler.impl;

import core.basesyntax.dao.Dao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.transactionhandler.TransactionHandler;

public class ReturnHandler implements TransactionHandler {
    private final Dao dao;

    public ReturnHandler(Dao dao) {
        this.dao = dao;
    }

    @Override
    public void handleTransaction(FruitTransaction transaction) {
        if (transaction.getQuantity() <= 0) {
            throw new RuntimeException("The number of fruits returned must be positive!");
        }
        int currentQuantity = dao.getQuantity(transaction.getFruit());
        int newQuantity = currentQuantity + transaction.getQuantity();
        dao.add(transaction.getFruit(), newQuantity);
    }
}
