package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitTransactionHandler;
import java.util.Map;

public class PurchaseHandler implements FruitTransactionHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Map<String, Integer> storageMap = Storage.storageMap;
        String fruit = fruitTransaction.getFruit();
        int quantityToBuy = fruitTransaction.getQuantity();
        int amountInStorage = storageMap.get(fruit);
        if (amountInStorage < quantityToBuy) {
            throw new RuntimeException(
                    String.format("Cannot buy %d %s. Amount in storage is %d",
                            quantityToBuy,
                            fruit,
                            amountInStorage)
            );
        }
        storageMap.put(fruit, amountInStorage - quantityToBuy);
    }
}
