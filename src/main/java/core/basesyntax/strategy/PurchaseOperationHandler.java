package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int beginQuality = Storage.getStorageFruit().getOrDefault(fruit, 0);
        int newQuality = beginQuality - fruitTransaction.getQuantity();

        if (newQuality < 0) {
            throw new RuntimeException("There isn't that much fruit in the store");
        }
        Storage.getStorageFruit().put(fruit, newQuality);
    }
}
