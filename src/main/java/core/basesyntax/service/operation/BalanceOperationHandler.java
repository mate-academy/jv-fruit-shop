package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void completeOperation(FruitTransaction fruitTransaction) {
        Storage.storage.put(fruitTransaction.getName(), fruitTransaction.getQuantity());
    }
}
