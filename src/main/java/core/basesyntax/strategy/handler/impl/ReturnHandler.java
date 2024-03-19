package core.basesyntax.strategy.handler.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.exception.ReturnFruitException;
import core.basesyntax.models.Fruit;
import core.basesyntax.strategy.handler.OperationHandler;

public class ReturnHandler extends OperationHandler {
    public ReturnHandler(FruitStorage fruitStorage) {
        super(fruitStorage);
    }

    @Override
    public void handle(Fruit fruit, Integer quantity) {
        Integer currentBalance = fruitStorage.storage().get(fruit);
        if (!fruitStorage.storage().containsKey(fruit)) {
            throw new ReturnFruitException("Can`t return absent fruit" + fruit);
        }
        if (currentBalance < quantity) {
            throw new ReturnFruitException(
                    "Cannot return more fruits: " + fruit
                            + " than were bought!" + System.lineSeparator()
                            + "Quantity to return: " + quantity + System.lineSeparator()
                            + "Currently available balance: " + currentBalance
            );
        }
        fruitStorage.storage().put(fruit, currentBalance - quantity);
    }
}
