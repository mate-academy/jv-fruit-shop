package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.FruitTransactionHandler;
import java.util.Map;

public class ReturnTransactionHandler implements FruitTransactionHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction, Storage storage) {
        Map<String, Integer> storageMap = storage.getStorageMap();
        String fruit = fruitTransaction.getFruit();
        int returnAmount = fruitTransaction.getQuantity();
        int amountBeforeReturning = storageMap.get(fruit);
        storageMap.put(fruit, returnAmount + amountBeforeReturning);
    }
}
