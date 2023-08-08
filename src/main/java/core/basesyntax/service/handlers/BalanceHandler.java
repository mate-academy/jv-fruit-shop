package core.basesyntax.service.handlers;

import core.basesyntax.service.OperationHandler;
import core.basesyntax.storage.Storage;

public class BalanceHandler implements OperationHandler {

    @Override
    public void handler(String fruit, int amount) {
        Storage.storage.put(fruit, amount);
    }
}
