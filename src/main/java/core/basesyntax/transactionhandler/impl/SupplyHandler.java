package core.basesyntax.transactionhandler.impl;

import core.basesyntax.dao.Dao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.transactionhandler.TransactionHandler;

public class SupplyHandler implements TransactionHandler {
    private final Dao dao;

    public SupplyHandler(Dao dao) {
        this.dao = dao;
    }

    @Override
    public void handleTransaction(FruitTransaction transaction) {
        int currentQuantity = dao.getQuantity(transaction.getFruit());
        int newQuantity = currentQuantity + transaction.getQuantity();
        dao.add(transaction.getFruit(), newQuantity);
    }
}
