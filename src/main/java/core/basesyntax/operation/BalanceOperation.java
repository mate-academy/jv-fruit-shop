package core.basesyntax.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void processOperation(FruitTransaction fruitTransaction) {
        Storage.storage.put(fruitTransaction.getFruit(), fruitTransaction.getAmount());
    }
}
