package core.basesyntax.str.impl;

import core.basesyntax.database.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.str.OperationHandler;

public class BuyOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int oldQuantity = FruitStorage.fruit.get(transaction.getFruit());
        if (oldQuantity < transaction.getQuantity()) {
            throw new RuntimeException("Not enough " + transaction.getFruit() + " for purchase!");
        }
        FruitStorage.fruit.put(transaction.getFruit(), oldQuantity - transaction.getQuantity());

    }
}
