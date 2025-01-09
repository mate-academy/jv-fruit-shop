package core.basesyntax.handler;

import core.basesyntax.database.Storage;

public class SupplyHandler implements OperationHandler {
    @Override
    public void operate(String fruitType, int amount) {
        int amountAfterSupply = Storage.storage.get(fruitType) + amount;
        Storage.storage.put(fruitType,amountAfterSupply);
    }
}
