package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseHandlerImpl implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        Integer amount = fruitTransaction.getQuantity();
        if (Storage.fruits.get(fruit) >= amount) {
            Storage.fruits.put(fruit, Storage.fruits.get(fruit) - amount);
        } else {
            throw new RuntimeException(
                    "There is not enough fruits for the purchase in the Storage");
        }
    }
}
