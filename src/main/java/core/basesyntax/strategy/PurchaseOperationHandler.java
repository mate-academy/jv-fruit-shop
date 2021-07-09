package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.Transaction;
import core.basesyntax.model.Fruit;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int apply(Transaction transaction) {
        Fruit fruit = new Fruit(transaction.getName());
        int currentBalance = Storage.fruits.getOrDefault(fruit, 0);
        int newBalance = currentBalance - transaction.getQuantity();
        if (newBalance < 0) {
            throw new RuntimeException("Not enough fruits!");
        }
        Storage.fruits.put(fruit, newBalance);
        return newBalance;
    }
}
