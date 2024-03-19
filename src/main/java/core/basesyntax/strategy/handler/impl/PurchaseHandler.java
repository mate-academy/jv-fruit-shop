package core.basesyntax.strategy.handler.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.exception.PurchaseFruitException;
import core.basesyntax.models.Fruit;
import core.basesyntax.strategy.handler.OperationHandler;

public class PurchaseHandler extends OperationHandler {
    public PurchaseHandler(FruitStorage fruitStorage) {
        super(fruitStorage);
    }

    @Override
    public void handle(Fruit fruit, Integer quantity) {
        Integer currentBalance = fruitStorage.storage().get(fruit);
        if (currentBalance < quantity) {
            throw new PurchaseFruitException(
                    "Unable to purchase fruit: " + fruit
                            + " balance is less than purchase quantity."
                            + System.lineSeparator()
                            + "Current balance: " + currentBalance
                            + System.lineSeparator()
                            + "Purchase quantity: " + quantity
            );
        }
        fruitStorage.storage().put(fruit, currentBalance - quantity);
    }
}
