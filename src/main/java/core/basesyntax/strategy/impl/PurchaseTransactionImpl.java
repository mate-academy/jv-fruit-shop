package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class PurchaseTransactionImpl implements OperationHandler {
    @Override
    public void handle(String fruit, int quantity) {
        Map<String, Integer> storageMap = Storage.getFruitStore();
        int currentStoredFruit = storageMap.get(fruit);
        storageMap.put(fruit, currentStoredFruit - quantity);
        Storage.setFruitStore(storageMap);
    }
}
