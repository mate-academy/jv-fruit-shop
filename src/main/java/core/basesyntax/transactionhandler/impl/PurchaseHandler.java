package core.basesyntax.transactionhandler.impl;

import core.basesyntax.dao.Dao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.transactionhandler.TransactionHandler;

public class PurchaseHandler implements TransactionHandler {
    private final Dao dao;

    public PurchaseHandler(Dao dao) {
        this.dao = dao;
    }

    @Override
    public void handleTransaction(FruitTransaction transaction) {
        int currentQuantity = dao.getQuantity(transaction.getFruit());
        int newQuantity = currentQuantity - transaction.getQuantity();
        if (newQuantity >= 0) {
            dao.add(transaction.getFruit(), newQuantity);
        } else {
            throw new RuntimeException("Not enough fruit to sell.There are "
                    + currentQuantity + " pcs");
        }
    }
}
