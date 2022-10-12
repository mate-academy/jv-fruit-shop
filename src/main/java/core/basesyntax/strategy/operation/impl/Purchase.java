package core.basesyntax.strategy.operation.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.operation.Operation;

public class Purchase implements Operation {
    @Override
    public void apply(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        if (!Storage.storage.containsKey(fruit)) {
            throw new RuntimeException(fruit + " is out of stock");
        } else {
            Integer currentQuantity = Storage.storage.get(fruit) - transaction.getSum();
            Storage.storage.put(fruit, currentQuantity);
        }
    }
}
