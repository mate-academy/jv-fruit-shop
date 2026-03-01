package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void performOperation(FruitTransaction transaction) {
        int quantity = transaction.getQuantity();

        if (quantity < 0) {
            throw new RuntimeException("Balance cannot be negative");
        }

        Storage.put(transaction.getFruit(), quantity);
    }
}
