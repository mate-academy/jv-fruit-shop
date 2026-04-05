package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class BalanceHandler implements OperationHandler {
    private final Storage storage;

    public BalanceHandler(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handle(String fruit, int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Balance cannot be negative");
        }
        storage.add(fruit, quantity);
    }
}
