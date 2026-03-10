package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void process(FruitTransaction fruitTransaction) {
        validateTransaction(fruitTransaction);
        int quantity = Storage.getAll().getOrDefault(fruitTransaction.getFruit(), 0);
        int updatedQuantity = quantity - fruitTransaction.getQuantity();

        if (updatedQuantity < 0) {
            throw new RuntimeException("Purchase operation failed. "
                    + "Not enough fruit in storage to sell.");
        }

        Storage.put(fruitTransaction.getFruit(), updatedQuantity);
    }
}
