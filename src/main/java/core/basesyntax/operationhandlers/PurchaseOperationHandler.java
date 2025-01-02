package core.basesyntax.operationhandlers;

import core.basesyntax.storage.Storage;

public class PurchaseOperationHandler {
    private Storage storage;

    public PurchaseOperationHandler(Storage storage) {
        this.storage = storage;
    }

    public int purchase(String fruitType, int amount) {
        int purchaseAmount = storage.getOrDefault(fruitType, 0);
        if (purchaseAmount < amount) {
            throw new IllegalStateException("Not enough fruits");
        }
        int newAmount = storage.get(fruitType) - amount;
        storage.put(fruitType,newAmount);
        return newAmount;
    }
}
