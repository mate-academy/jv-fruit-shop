package core.basesyntax.transactions.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.transactions.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void processTransaction(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        int balance = Storage.STORAGE_VALUE.get(fruit);
        int updateBalance = quantity + balance;
        Storage.STORAGE_VALUE.put(fruit, updateBalance);
    }
}
