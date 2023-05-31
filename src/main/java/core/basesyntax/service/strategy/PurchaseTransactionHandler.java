package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.FruitTransactionHandler;
import java.util.Map;

public class PurchaseTransactionHandler implements FruitTransactionHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction, Storage storage) {
        Map<String, Integer> storageMap = storage.getStorageMap();
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
