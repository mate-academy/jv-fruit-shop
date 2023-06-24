package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction transaction) {
        int oldQuantity = Storage.fruitsStorage.get(transaction.getFruit());
        if (oldQuantity < transaction.getQuantity()) {
            throw new RuntimeException("Not enough " + transaction.getFruit() + " for purchase");
        } else {
            Storage.fruitsStorage.put(transaction.getFruit(),
                    oldQuantity - transaction.getQuantity());
        }
    }
}
