package core.basesyntax.strategy.operation.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.storage.Storage;

public class FruitService {
    public void processIncomingTransaction(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        if (!Storage.storage.containsKey(fruit)) {
            Storage.storage.put(fruit, transaction.getSum());
        } else {
            Integer currentQuantity = Storage.storage.get(fruit) + transaction.getSum();
            Storage.storage.put(fruit, currentQuantity);
        }
    }

    public void processExpenseTransaction(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        if (!Storage.storage.containsKey(fruit)) {
            throw new RuntimeException(fruit + " is out of stock");
        } else {
            Integer currentQuantity = Storage.storage.get(fruit) - transaction.getSum();
            Storage.storage.put(fruit, currentQuantity);
        }
    }
}
