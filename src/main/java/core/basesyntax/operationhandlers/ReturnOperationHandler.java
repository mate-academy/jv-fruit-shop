package core.basesyntax.operationhandlers;

import core.basesyntax.storage.Storage;

public class ReturnOperationHandler {
    private Storage storage;

    public ReturnOperationHandler(Storage storage) {
        this.storage = storage;
    }

    public int returnFruit(String fruitType, int amount) {
        int returnedAmount = storage.getOrDefault(fruitType, 0) + amount;
        storage.put(fruitType, returnedAmount);
        return returnedAmount;
    }
}
