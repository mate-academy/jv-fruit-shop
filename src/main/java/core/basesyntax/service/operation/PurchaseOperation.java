package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void process(FruitTransaction transaction) {
        int currentBalance = Storage.fruits.getOrDefault(transaction.getFruit(), 0);
        int newBalance = currentBalance - transaction.getQuantity();
        if (newBalance < 0) {
            throw new RuntimeException("Not enough fruits: " + transaction.getFruit()
                    + ". Available: " + currentBalance
                    + ", requested: " + transaction.getQuantity());
        }
        Storage.fruits.put(transaction.getFruit(), newBalance);
    }
}
