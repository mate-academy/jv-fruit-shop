package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;

public class BalanceHandler implements ActivityHandler {
    private final Storage storage;

    public BalanceHandler(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void operate(String fruit, int quantity) {
        storage.getData().put(fruit,quantity);
    }
}
