package core.basesyntax.strategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    private static final String INVALID_SUPPLY_QUANTITY = "Invalid supply quantity: ";

    @Override
    public void process(FruitTransaction transaction) {
        String fruit = transaction.getFruitName();
        int quantity = transaction.getQuantity();
        if (quantity < 0) {
            throw new IllegalArgumentException(INVALID_SUPPLY_QUANTITY + quantity);
        }
        Storage.fruits.merge(fruit, quantity, Integer::sum);
    }
}
