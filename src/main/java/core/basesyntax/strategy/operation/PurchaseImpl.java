package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.models.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class PurchaseImpl implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        Integer amount = fruitTransaction.getQuantity();
        if (Storage.storage.get(fruit) >= amount) {
            Storage.storage.put(fruit, Storage.storage.get(fruit) - amount);
        } else {
            throw new RuntimeException(
                    "There is not enough fruits for the purchase in the Storage");
        }
    }
}