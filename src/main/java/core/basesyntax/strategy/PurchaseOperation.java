package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.db.Storage;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        Integer currentQuantity = Storage.getFruitQuantity(fruitTransaction.getFruit());
        if (currentQuantity < fruitTransaction.getQuantity()) {
            throw new RuntimeException("Not enough fruits in the storage...");
        }
        Storage.reduceFruitQuantity(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
