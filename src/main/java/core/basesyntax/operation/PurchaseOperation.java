package core.basesyntax.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void processOperation(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int amountInStorage = Storage.storage.get(fruit);
        int amountToBuy = fruitTransaction.getAmount();
        if (amountInStorage < amountToBuy) {
            throw new RuntimeException("Not enough fruit in the storage for this operation");
        }
        Storage.storage.put(fruit, amountInStorage - amountToBuy);
    }
}
