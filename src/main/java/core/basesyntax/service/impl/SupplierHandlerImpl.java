package core.basesyntax.service.impl;

import core.basesyntax.db.FruitsStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class SupplierHandlerImpl implements OperationHandler {
    @Override
    public void applyOperation(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruitName();
        int fruitQuantityToAdd = fruitTransaction.getFruitQuantity();
        if (FruitsStorage.fruitsStorage.containsKey(fruitName)) {
            int fruitQuantityInStorage = FruitsStorage.fruitsStorage.get(fruitName);
            fruitQuantityToAdd = fruitQuantityToAdd + fruitQuantityInStorage;
        }
        FruitsStorage.fruitsStorage.put(fruitName, fruitQuantityToAdd);
    }
}
