package core.basesyntax.strategy.handler;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.storage.Storage;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void apply(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        if (Storage.storage.containsKey(fruit)) {
            Integer currentQuantity = Storage.storage.get(fruit);
            Storage.storage.put(fruit, currentQuantity);
        } else {
            Storage.storage.put(fruit, transaction.getQuantity());
        }
    }
}
