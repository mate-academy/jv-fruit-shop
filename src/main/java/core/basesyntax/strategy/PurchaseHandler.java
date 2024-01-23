package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.transaction.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int currentQuantity = Storage.storage.getOrDefault(transaction.getFruit(), 0);
        if ((currentQuantity -  transaction.getQuantity()) < 0) {
            throw new RuntimeException("There is only " + currentQuantity + " of this fruit");
        }
        Storage.storage.put(transaction.getFruit(), currentQuantity - transaction.getQuantity());
    }
}
