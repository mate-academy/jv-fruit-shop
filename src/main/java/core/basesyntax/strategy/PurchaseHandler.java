package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void execute(String fruit, int quantity) {
        int storedAmount = Storage.STORAGE.get(fruit);
        if (storedAmount - quantity < 0) {
            throw new RuntimeException("Quantity of " + fruit
                    + " in storage is less than " + quantity);
        }
        Storage.STORAGE.put(fruit, storedAmount - quantity);
    }
}
