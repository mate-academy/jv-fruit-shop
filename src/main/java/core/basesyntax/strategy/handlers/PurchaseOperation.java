package core.basesyntax.strategy.handlers;

import core.basesyntax.data.FruitTransaction;
import core.basesyntax.storage.FruitStorage;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void handle(FruitTransaction fruit, FruitStorage fruitStorage) {
        if (fruitStorage.getAmount(fruit.getFruit()) < fruit.getQuantity()) {
            throw new IllegalArgumentException("Not enough fruits available in storage.");
        }
        fruitStorage.purchaseItem(fruit.getFruit(), fruit.getQuantity());
    }
}
