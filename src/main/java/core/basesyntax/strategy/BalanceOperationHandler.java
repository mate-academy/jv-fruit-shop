package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void processOperation(FruitTransaction fruitTransaction) {
        Storage.storage.put(fruitTransaction.getNameOfObject(), fruitTransaction.getAmount());
    }
}
