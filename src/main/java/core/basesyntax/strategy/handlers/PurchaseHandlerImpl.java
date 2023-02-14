package core.basesyntax.strategy.handlers;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseHandlerImpl implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruitName();
        Integer storageFruitQuantity = Storage.storage.get(fruitName);
        int fruitQuantity = fruitTransaction.getQuantity();
        if (storageFruitQuantity - fruitQuantity < 0) {
            throw new RuntimeException("Not enough " + fruitName);
        }
        Storage.storage.put(fruitName, storageFruitQuantity - fruitQuantity);
    }
}
