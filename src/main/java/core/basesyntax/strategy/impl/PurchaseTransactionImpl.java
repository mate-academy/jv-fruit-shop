package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.FruitTransaction;
import java.util.Map;

public class PurchaseTransactionImpl implements FruitTransaction {

    @Override
    public void getTransaction(String fruit, int quantity) {
        Fruit currentFruit = Fruit.valueOf(fruit.toUpperCase());
        Map<Fruit, Integer> storageMap = Storage.getFruitStore();
        int currentStoredFruit = storageMap.get(currentFruit);
        storageMap.put(currentFruit, currentStoredFruit - quantity);
        Storage.setFruitStore(storageMap);
    }
}
