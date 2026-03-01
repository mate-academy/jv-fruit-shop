package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void performOperation(FruitTransaction transaction) {
        int quantity = transaction.getQuantity();

        if (quantity < 0) {
            throw new RuntimeException("Return quantity cannot be negative");
        }

        String fruit = transaction.getFruit();
        int current = Storage.get(fruit);

        Storage.put(fruit, current + quantity);
    }
}
