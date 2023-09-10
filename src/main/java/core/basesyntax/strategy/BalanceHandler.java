package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class BalanceHandler implements OperationHandler {
    @Override
    public void execute(String fruitName, int quantity) {
        Storage.storage.put(fruitName, quantity);
    }
}
