package core.basesyntax.operationhandlers;

import core.basesyntax.storage.Storage;

import java.util.Map;

public class PurchaseOperationHandler implements OperationHandler {
    private Storage storage = new Storage();

    @Override
    public int apply(String fruitType, int amount) {
        Map<String, Integer> storage1 = storage.getStorage();
        int purchaseAmount = storage1.getOrDefault(fruitType, 0);
        if (purchaseAmount < amount) {
            throw new IllegalStateException("Not enough fruits");
        }
        int newAmount = storage1.get(fruitType) - amount;
        storage1.put(fruitType,newAmount);
        return newAmount;
    }
}
