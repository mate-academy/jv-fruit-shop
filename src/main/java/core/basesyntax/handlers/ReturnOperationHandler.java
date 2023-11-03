package core.basesyntax.handlers;

import core.basesyntax.storage.Storage;
import core.basesyntax.transaction.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {

    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        Storage.getFruitBalance().put(fruitTransaction.getFruit(),
                Storage.getFruitBalance().get(fruitTransaction.getFruit())
                        + fruitTransaction.getQuantity());
    }
}
