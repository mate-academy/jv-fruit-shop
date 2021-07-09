package core.basesyntax.strategy;

import core.basesyntax.dto.Transaction;
import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;

public class AdditionOperationHandler implements OperationHandler {
    @Override
    public int apply(Transaction transaction) {
        Fruit fruit = new Fruit(transaction.getName());
        int quantity = Storage.storage.getOrDefault(fruit, 0) + transaction.getQuantity();
        Storage.storage.put(fruit, quantity);
        return quantity;
    }
}

