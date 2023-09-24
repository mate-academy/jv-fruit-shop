package core.basesyntax.service.transaction.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.transaction.TransactionHandler;

public class SupplyTransactionHandler implements TransactionHandler {
    @Override
    public void executeTransaction(FruitTransaction transaction) {
        Integer oldQuantity = Storage.get(transaction.getFruit());
        Integer newQuantity = oldQuantity + transaction.getQuantity();
        Storage.updatePair(transaction.getFruit(), newQuantity);
    }
}
