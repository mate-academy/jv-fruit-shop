package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void operate(FruitTransaction transaction) {
        if (transaction == null) {
            throw new RuntimeException("Transaction can not be null");
        }
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("Quantity can't be negative " + transaction.getQuantity());
        }
        Storage.fruits.put(transaction.getFruit(), transaction.getQuantity());
    }
}
