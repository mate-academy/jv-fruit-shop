package core.basesyntax.service.operations;

import core.basesyntax.infrastructure.db.Storage;
import core.basesyntax.service.FruitTransaction;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void run(FruitTransaction fruitTransaction) {
        this.isFruitAvailable(fruitTransaction);

        if (Storage.STORAGE.get(fruitTransaction.getFruit()) < fruitTransaction.getQuantity()) {
            throw new RuntimeException("Too little of product: " + fruitTransaction.getFruit());
        }
        Storage.STORAGE.put(fruitTransaction.getFruit(),
                Storage.STORAGE.get(fruitTransaction.getFruit()) - fruitTransaction.getQuantity());
    }
}
