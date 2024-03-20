package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.exception.NotEnoughFruitException;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handleFruitOperation(String fruit, Integer quantity) {
        Integer fruitsQuantity = Storage.fruits.get(fruit);
        if (fruitsQuantity < quantity) {
            throw new NotEnoughFruitException("Not enough " + fruit
                    + " quantity. Actual quantity: " + quantity);
        }
        Storage.fruits.put(fruit, fruitsQuantity - quantity);
    }
}
