package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int existingAmount = Storage.storage.get(fruitTransaction.getFruit());
        int purchaseAmount = fruitTransaction.getQuantity();
        if (purchaseAmount > existingAmount) {
            throw new RuntimeException("Not enough fruits in the storage."
                    + " Existing amount:" + existingAmount
                    + " is less than Purchase amount:" + existingAmount);
        }
        Storage.storage.put(fruitTransaction.getFruit(),
                existingAmount - purchaseAmount);
    }
}
