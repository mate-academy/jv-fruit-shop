package core.basesyntax.strategy.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void apply(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        Integer currentCount = Storage.storage.get(fruit);
        Storage.storage.put(
                fruit, currentCount == null
                        ? transaction.getQuantity()
                : currentCount + transaction.getQuantity());
    }
}
