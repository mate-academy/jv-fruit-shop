package core.basesyntax.service.operations;

import core.basesyntax.infrastructure.db.Storage;
import core.basesyntax.service.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void run(FruitTransaction fruitTransaction) {
        this.isFruitAvailable(fruitTransaction);

        Storage.STORAGE.put(fruitTransaction.getFruit(),
                Storage.STORAGE.get(fruitTransaction.getFruit()) + fruitTransaction.getQuantity());
    }
}
