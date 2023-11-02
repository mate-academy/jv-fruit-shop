package core.basesyntax.transactions.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.transactions.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {

    @Override
    public void processTransaction(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        Integer balance = Storage.STORAGE_VALUE.get(fruit);
        Storage.STORAGE_VALUE.put(fruit, balance + quantity);
    }
}
