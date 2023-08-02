package core.basesyntax.strategy.handlers;

import core.basesyntax.db.Storage;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void operate(String fruitType, int amount) {
        int newAmount = Storage.storage.get(fruitType) - amount;
        if (newAmount < 0) {
            throw new RuntimeException("Can't do purchase, because amount will be less than 0");
        }
        Storage.storage.put(fruitType, newAmount);
    }
}
