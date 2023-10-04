package core.basesyntax.operation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Storage;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void set(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        if (Storage.fruits.containsKey(fruit)) {
            Storage.fruits.put(fruit, Storage.fruits.get(fruit) - fruitTransaction.getQuantity());
        }
    }
}
