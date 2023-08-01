package core.basesyntax.handlers;

import core.basesyntax.storage.Storage;

public class BalanceHandler implements OperationHandler {
    @Override
    public void handler(String fruit, int value) {
        Storage.storage.put(fruit, value);
    }
}
