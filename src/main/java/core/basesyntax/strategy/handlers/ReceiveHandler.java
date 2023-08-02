package core.basesyntax.strategy.handlers;

import core.basesyntax.db.Storage;

public class ReceiveHandler implements OperationHandler {
    @Override
    public void operate(String fruitType, int amount) {
        int currentAmount = Storage.storage.get(fruitType);
        Storage.storage.put(fruitType,currentAmount + amount);
    }
}
