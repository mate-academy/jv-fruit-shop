package core.basesyntax.handler;

import core.basesyntax.database.Storage;

public class BalanceHandler implements OperationHandler {

    @Override
    public void operate(String fruitType, int amount) {
        Storage.storage.put(fruitType, amount);
    }
}
