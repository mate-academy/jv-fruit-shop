package core.basesyntax.strategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void process(FruitTransaction transaction) {
        String fruit = transaction.getFruitName();
        int quantity = transaction.getQuantity();
        if (quantity < 0) {
            throw new IllegalArgumentException("Invalid quantity: " + quantity);
        }
        Storage.mergeFruitQuantity(fruit, quantity);
    }
}
