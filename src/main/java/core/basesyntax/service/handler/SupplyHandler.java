package core.basesyntax.service.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyHandler implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        int currentValue = Storage.fruits.get(transaction.getFruit());
        Storage.fruits.put(transaction.getFruit(), currentValue + transaction.getQuantity());
    }
}
