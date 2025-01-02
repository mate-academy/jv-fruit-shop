package core.basesyntax.operationhandlers;

import core.basesyntax.storage.Storage;

public class SupplyOperationHandler {
    private Storage storage;

    public SupplyOperationHandler(Storage storage) {
        this.storage = storage;
    }

    public int supply(String fruitType, int amount) {
        int newAmount = storage.get(fruitType) + amount;
        storage.put(fruitType,newAmount);
        return newAmount;
    }
}
