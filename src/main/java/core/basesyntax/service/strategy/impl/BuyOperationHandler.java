package core.basesyntax.service.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationHandler;

public class BuyOperationHandler implements OperationHandler {

    @Override
    public void updateNumberOfFruit(FruitTransaction fruitTransaction) {
        Integer numberAfterSelling = Storage.STORAGE.get(fruitTransaction.getFruit())
                - fruitTransaction.getQuantity();
        if (numberAfterSelling < 0) {
            throw new RuntimeException("You don't have enough fruits to sell them.");
        } else {
            Storage.STORAGE.put(fruitTransaction.getFruit(), numberAfterSelling);
        }
    }
}
