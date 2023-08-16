package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationActivity;

public class PurchaseOperationActivity implements OperationActivity {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int purchaseQuantity = transaction.getQuantity();
        int storageQuantity = Storage.fruitTransactionsMap.get(fruit);
        if (storageQuantity - purchaseQuantity < 0) {
            throw new RuntimeException("Isn't enough fruit in storage");
        }
        Storage.fruitTransactionsMap.put(fruit, storageQuantity - purchaseQuantity);
    }
}
