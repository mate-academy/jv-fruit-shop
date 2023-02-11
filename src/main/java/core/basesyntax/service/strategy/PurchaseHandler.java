package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruitName = transaction.getFruit();
        Integer storageFruitQuantity = Storage.storageFruits.get(fruitName);
        int fruitQuantity = transaction.getQuantity();
        if (storageFruitQuantity - fruitQuantity < 0) {
            throw new RuntimeException("Not enough " + fruitName);
        }
        Storage.storageFruits.put(fruitName, storageFruitQuantity - fruitQuantity);
    }
}
