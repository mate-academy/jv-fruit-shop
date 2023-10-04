package core.basesyntax.strategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction transaction) {
        int oldQuantity = Storage.fruits.get(transaction.getFruit());
        Storage.fruits.put(transaction.getFruit(), oldQuantity + transaction.getQuantity());
    }
}
