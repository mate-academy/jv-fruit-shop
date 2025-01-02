package core.basesyntax.operationHandlers;

import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;

public class BalanceOperationHandler {
    private Storage storage;

    public BalanceOperationHandler(Storage storage) {
        this.storage = storage;
    }

    public int balance(String fruitType, int amount) {
        storage.put(fruitType,amount);
        return amount;
    }
}
