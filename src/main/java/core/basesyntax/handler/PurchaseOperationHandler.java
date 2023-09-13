package core.basesyntax.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Fruit fruit = transaction.getFruit();
        Integer currentQuantity = Storage.storage.get(fruit);
        if (currentQuantity - transaction.getQuantity() < 0) {
            throw new RuntimeException("Less product than the buyer needs");
        }
        Storage.storage.put(fruit, currentQuantity - transaction.getQuantity());
    }
}