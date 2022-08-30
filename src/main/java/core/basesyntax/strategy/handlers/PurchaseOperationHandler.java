package core.basesyntax.strategy.handlers;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Fruit fruit = transaction.getFruit();
        if (!Storage.storage.containsKey(fruit)) {
            Storage.storage.put(fruit, (-1 * transaction.getQuantity()));
        } else {
            Integer currentQuantity = Storage.storage.get(fruit);
            Storage.storage.put(fruit, currentQuantity - transaction.getQuantity());
        }
    }
}
