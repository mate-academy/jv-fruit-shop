package core.basesyntax.service.impl;

import core.basesyntax.db.FruitsStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class PurchaseHandlerImpl implements OperationHandler {
    @Override
    public void applyOperation(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruitName();
        int quantityToSubtract = fruitTransaction.getFruitQuantity();
        int fruitQuantityInStorage = FruitsStorage.fruitsStorage.get(fruitName);
        if (FruitsStorage.fruitsStorage.containsKey(fruitName)) {
            fruitQuantityInStorage = fruitQuantityInStorage - quantityToSubtract;
        }
        FruitsStorage.fruitsStorage.put(fruitName, fruitQuantityInStorage);
    }
}
