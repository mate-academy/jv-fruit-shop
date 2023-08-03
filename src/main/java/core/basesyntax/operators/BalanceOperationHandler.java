package core.basesyntax.operators;

import core.basesyntax.db.Storage;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void execute(String product, int amount) {
        Storage.storage.put(product, amount);
    }
}
