package core.basesyntax.handler;

import core.basesyntax.database.Storage;

public class ReturnHandler implements OperationHandler {
    @Override
    public void operate(String fruitType, int amount) {
        int amountAfterReturn = Storage.storage.get(fruitType) + amount;
        Storage.storage.put(fruitType, amountAfterReturn);
    }
}
