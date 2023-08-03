package core.basesyntax.strategy.handlers;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReceiveHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction fruitTransaction) {
        int currentAmount = Storage.storage.get(fruitTransaction.getFruit());
        Storage.storage.put(fruitTransaction.getFruit(),currentAmount
                + fruitTransaction.getQuantity());
    }
}
