package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException(
                    "Transaction cannot be null");
        }

        if (transaction.getFruit() == null
                || transaction.getFruit().isBlank()) {
            throw new IllegalArgumentException(
                    "Fruit cannot be null or empty");
        }

        if (transaction.getQuantity() < 0) {
            throw new IllegalArgumentException(
                    "Quantity cannot be negative");
        }

        Storage.put(transaction.getFruit(), transaction.getQuantity());
    }

    private void validateTransaction(FruitTransaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction cannot be null");
        }
        if (transaction.getQuantity() < 0) {
            throw new IllegalArgumentException(
                    "Quantity cannot be negative");
        }
    }
}
