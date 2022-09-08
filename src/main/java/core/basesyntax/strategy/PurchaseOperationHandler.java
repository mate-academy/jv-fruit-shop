package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Integer currentQuantity = Storage.storageFruits.get(transaction.getFruit());
        if (currentQuantity < transaction.getQuantity()) {
            throw new RuntimeException("Not enough fruit on the balance");
        }
        Storage.storageFruits.put(transaction.getFruit(),
                currentQuantity - transaction.getQuantity());
    }
}
