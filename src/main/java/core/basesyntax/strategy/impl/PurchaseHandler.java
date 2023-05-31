package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int quantityToBuy = fruitTransaction.getQuantity();
        String fruit = fruitTransaction.getFruit();
        Map<String, Integer> storageMap = Storage.storageMap;
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
