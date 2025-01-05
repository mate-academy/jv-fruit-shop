package core.basesyntax.operationhandlers;

import core.basesyntax.storage.Storage;

public class BalanceOperationHandler implements OperationHandler {
    private Storage storage;

    public BalanceOperationHandler(Storage storage) {
        this.storage = storage;
    }

    @Override
    public int apply(String fruitType, int amount) {
        storage.put(fruitType, amount);
        return amount;
    }
}
