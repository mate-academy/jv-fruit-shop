package core.basesyntax.operations;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.storage.Storage;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void apply(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        if (!Storage.storage.containsKey(fruit)) {
            Storage.storage.put(fruit, transaction.getSum());
        } else {
            Integer currentQuantity = Storage.storage.get(fruit) - transaction.getSum();
            Storage.storage.put(fruit, currentQuantity);
        }
    }
}
