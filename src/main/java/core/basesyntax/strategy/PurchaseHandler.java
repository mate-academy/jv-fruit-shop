package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.transaction.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int currentQuantity;
        try {
            currentQuantity = Storage.storage.get(transaction.getFruit());
        } catch (NullPointerException e) {
            throw new RuntimeException("This fruit is not available");
        }
        if ((currentQuantity -  transaction.getQuantity()) < 0) {
            throw new RuntimeException("There is only " + currentQuantity + " of this fruit");
        } else {
            Storage.storage.put(transaction.getFruit(), currentQuantity - transaction.getQuantity());
        }
    }
}
