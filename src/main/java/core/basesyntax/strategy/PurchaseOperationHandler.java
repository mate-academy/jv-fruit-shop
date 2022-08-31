package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        Fruit fruit = fruitTransaction.getFruit();
        Integer currentQuantity = Storage.getAll().get(fruit);
        if (currentQuantity >= fruitTransaction.getQuantity()) {
            Storage.getAll().put(fruit, currentQuantity - fruitTransaction.getQuantity());
        } else {
            throw new RuntimeException("Currently unavailable");
        }
    }
}
