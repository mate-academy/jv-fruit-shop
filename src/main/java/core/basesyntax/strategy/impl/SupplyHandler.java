package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitTransactionHandler;
import java.util.Map;

public class SupplyHandler implements FruitTransactionHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Map<String, Integer> storageMap = Storage.storageMap;
        String fruit = fruitTransaction.getFruit();
        int amountInStorage = storageMap.get(fruit);
        storageMap.put(fruit, amountInStorage + fruitTransaction.getQuantity());
    }
}
