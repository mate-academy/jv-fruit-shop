package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Integer balance = Storage.storage.getOrDefault(transaction.getFruit(), 0);
        if (balance != 0 && balance >= transaction.getQuantity()) {
            Integer result = balance - transaction.getQuantity();
            Storage.storage.put(transaction.getFruit(), result);
        } else {
            throw new RuntimeException("Their is no or not enough "
                    + transaction.getFruit() + " in fruit shop");
        }
    }
}
