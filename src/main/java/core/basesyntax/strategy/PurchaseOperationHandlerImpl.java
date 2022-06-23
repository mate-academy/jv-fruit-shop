package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandlerImpl implements OperationHandler {
    @Override
    public void changeQuantity(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() > Storage.storageMap.get(fruitTransaction.getFruit())) {
            throw new RuntimeException(
                    fruitTransaction.getFruit() + " cannot be purchase. They aren`t enough.");
        }
        Storage.storageMap.put(fruitTransaction.getFruit(),
                Storage.storageMap.get(fruitTransaction.getFruit())
                        - fruitTransaction.getQuantity());
    }
}
