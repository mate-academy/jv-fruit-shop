package core.basesyntax.handlers;

import core.basesyntax.db.Storage;

public class BalanceHandler implements OperationHandler {
    @Override
    public void operation(String fruit, int quantity) {
        Storage.storage.put(fruit, quantity);
    }
}
