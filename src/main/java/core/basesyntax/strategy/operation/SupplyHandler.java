package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;

public class SupplyHandler implements OperationHandler {
    @Override
    public void operate(String fruit, int quantity) {
        int valueBeforeOperation = 0;
        if (Storage.storage.keySet().contains(fruit)) {
            valueBeforeOperation = Storage.storage.get(fruit);
        }
        Storage.storage.put(fruit, valueBeforeOperation + quantity);
    }
}
