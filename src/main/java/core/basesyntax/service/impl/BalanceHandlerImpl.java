package core.basesyntax.service.impl;

import core.basesyntax.db.FruitsStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class BalanceHandlerImpl implements OperationHandler {
    @Override
    public void applyOperation(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruitName();
        int fruitQuantity = fruitTransaction.getFruitQuantity();
        if (FruitsStorage.fruitsStorage.containsKey(fruitName)) {
            int fruitQuantityInStorage = FruitsStorage.fruitsStorage.get(fruitName);
            fruitQuantity = fruitQuantity + fruitQuantityInStorage;
        }
        FruitsStorage.fruitsStorage.put(fruitName, fruitQuantity);
    }
}

