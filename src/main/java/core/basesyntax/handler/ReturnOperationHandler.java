package core.basesyntax.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Fruit fruit = transaction.getFruit();
        if (!Storage.storage.containsKey(fruit)) {
            Storage.storage.put(fruit, transaction.getQuantity());
        } else {
            Integer currentQuantity = Storage.storage.get(fruit);
            Storage.storage.put(fruit, currentQuantity + transaction.getQuantity());
        }
    }
}