package core.basesyntax.handler.impl;

import core.basesyntax.db.FruitsStorage;
import core.basesyntax.handler.BalanceHandler;
import core.basesyntax.model.FruitTransaction;

public class BalanceHandlerImpl implements BalanceHandler {
    @Override
    public boolean add(FruitTransaction fruitTransaction) {
        boolean isAdded = false;
        String fruitName = fruitTransaction.getFruitName();
        int fruitQuantity = fruitTransaction.getFruitQuantity();
        if (FruitsStorage.fruitsStorage.containsKey(fruitName)) {
            int existingFruitPrice = FruitsStorage.fruitsStorage.get(fruitName);
            fruitQuantity = fruitQuantity + existingFruitPrice;
        }
        FruitsStorage.fruitsStorage.put(fruitName, fruitQuantity);
        isAdded = true;
        return isAdded;
    }
}
