package core.basesyntax.strategy.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handle(Transaction transaction) {
        Fruit fruit = transaction.getProduct();
        Storage.fruits.put(fruit, transaction.getQuantity());
    }
}
