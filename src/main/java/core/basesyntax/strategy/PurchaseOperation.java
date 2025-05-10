package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        Integer currentQuantity = Storage.getFruitQuantity(fruitTransaction.getFruit());
        if (currentQuantity < fruitTransaction.getQuantity()) {
            throw new RuntimeException("Not enough fruits in the storage...");
        }
        Storage.setFruitQuantity(fruitTransaction.getFruit(),
                currentQuantity - fruitTransaction.getQuantity());
    }
}
