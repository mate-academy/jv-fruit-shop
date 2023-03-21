package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction) {
        Integer balance = Storage.storage.get(transaction.getFruit());
        if (balance == null) {
            throw new RuntimeException();
        }
        Integer result = balance - transaction.getQuantity();
        Storage.storage.put(transaction.getFruit(), result);
    }
}
