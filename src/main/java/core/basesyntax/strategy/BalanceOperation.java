package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        if (transaction == null || transaction.getFruit() == null) {
            throw new IllegalArgumentException("Transaction or fruit cannot be null");
        }
        if (transaction.getQuantity() < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }

        Storage.setFruitQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}
