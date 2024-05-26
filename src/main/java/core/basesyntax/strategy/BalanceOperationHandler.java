package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void processCommand(String[] data) {
        Storage.Storage.put(data[FRUIT], Integer.valueOf(data[QUANTITY]));
    }
}
