package core.basesyntax.strategy.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandlerImpl implements OperationHandler {

    @Override
    public void process(FruitTransaction transaction) {
        int currentQuantity = FruitStorage.fruitQuantities.get(transaction.getFruit());
        if (currentQuantity < transaction.getQuantity()) {
            throw new RuntimeException("Not enough " + transaction.getFruit()
                    + " in stock for purchase.");
        }
        FruitStorage.fruitQuantities
                .put(transaction.getFruit(), currentQuantity - transaction.getQuantity());
    }
}
