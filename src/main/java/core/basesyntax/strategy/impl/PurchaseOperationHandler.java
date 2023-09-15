package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        String key = transaction.getFruit();
        int newQuantity = Storage.DATABASE.get(key) - transaction.getQuantity();
        if (newQuantity < 0) {
            throw new RuntimeException("Not enough %ss in Storage. In Storage: %d, purchased: %d"
                    .formatted(key,
                            Storage.DATABASE.get(key), transaction.getQuantity()));
        }
        Storage.DATABASE.put(key, newQuantity);
    }
}
