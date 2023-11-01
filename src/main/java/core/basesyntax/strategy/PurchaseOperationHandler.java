package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String key = transaction.getFruit();
        Integer currentQuantity = Storage.storage.get(key);
        int newQuantity = currentQuantity - transaction.getQuantity();
        if (newQuantity < 0) {
            throw new RuntimeException("There is no enough goods in storage");
        }
        Storage.storage.put(key, newQuantity);
    }
}

