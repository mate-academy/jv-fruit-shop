package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction) {
        validateTransaction(transaction);

        String fruit = transaction.getFruit();
        int quantity = Storage.get(fruit) + transaction.getQuantity();

        Storage.put(fruit, quantity);
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
