package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int currentQuantity = Storage.getQuantity(transaction.getFruit());
        int updatedQuantity = currentQuantity - transaction.getQuantity();
        if (updatedQuantity < 0) {
            throw new RuntimeException(
                    "Not enough fruit in storage: " + transaction.getFruit()
            );
        }
        Storage.put(transaction.getFruit(), updatedQuantity);
    }
}
