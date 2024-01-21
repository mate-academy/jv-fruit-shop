package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.transaction.FruitTransaction;

public class SupplyHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int currentQuantity;
        try {
            currentQuantity = Storage.storage.get(transaction.getFruit());
        } catch (NullPointerException e) {
            throw new RuntimeException("This fruit is not available");
        }
        Storage.storage.put(transaction.getFruit(), currentQuantity + transaction.getQuantity());
    }
}
