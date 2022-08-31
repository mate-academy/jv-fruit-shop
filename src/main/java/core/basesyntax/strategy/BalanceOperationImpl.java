package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.storage.Storage;

public class BalanceOperationImpl implements OperationHandler {
    @Override
    public void apply(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        Storage.storage.put(fruit, transaction.getQuantity());
    }
}
