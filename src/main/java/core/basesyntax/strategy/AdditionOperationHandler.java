package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class AdditionOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        Fruit fruit = new Fruit(fruitTransaction.getFruitName());
        int quantity = fruitTransaction.getQuantity();
        if (Storage.storage.get(fruit) != null) {
            int oldQuantity = Storage.storage.get(fruit);
            quantity += oldQuantity;
        }
        Storage.storage.put(fruit, quantity);
    }
}
