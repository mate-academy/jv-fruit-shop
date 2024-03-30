package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionHandler;

public class PurchaseTransactionHandler implements TransactionHandler {
    @Override
    public void process(FruitTransaction transaction) {
        Integer currentQuantity = Storage.storage.get(transaction.getFruit());
        if (currentQuantity < transaction.getQuantity()) {
            throw new RuntimeException("It's not enough " + transaction.getFruit() + " in stock!");
        }
        Storage.storage.replace(
                transaction.getFruit(), currentQuantity - transaction.getQuantity());
    }
}
