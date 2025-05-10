package core.basesyntax.model.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int currentBalance = Storage.storage.getOrDefault(transaction.getFruit(), 0);
        int newBalance = currentBalance - transaction.getQuantity();

        if (newBalance < 0) {
            throw new RuntimeException("Insufficient balance for fruit: " + transaction.getFruit());
        }
        Storage.storage.put(transaction.getFruit(), newBalance);
    }
}
