package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruitName = transaction.getFruit();
        Integer storageFruitQuantity = Storage.storageFruits.get(fruitName);
        int fruitQuantity = transaction.getQuantity();
        Storage.storageFruits.replace(fruitName,
                storageFruitQuantity == null ? 0 : storageFruitQuantity + fruitQuantity);
    }
}
