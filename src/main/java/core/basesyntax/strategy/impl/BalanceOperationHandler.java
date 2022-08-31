package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void apply(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        if (!Storage.getStorage().containsKey(fruit)) {
            Storage.getStorage().put(fruit, transaction.getQuantity());
        } else {
            Integer currentQuantity = Storage.getStorage().get(fruit);
            Storage.getStorage().put(fruit,currentQuantity + transaction.getQuantity());
        }
    }
}
