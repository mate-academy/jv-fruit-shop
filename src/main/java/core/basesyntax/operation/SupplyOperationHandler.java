package core.basesyntax.operation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Storage;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void set(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        Storage.fruits.put(fruit, Storage.fruits.get(fruit) + fruitTransaction.getQuantity());
    }
}
