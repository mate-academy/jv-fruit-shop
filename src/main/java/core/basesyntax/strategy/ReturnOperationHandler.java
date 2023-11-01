package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String key = transaction.getFruit();
        Integer currentQuantity = Storage.storage.get(key);
        Integer newQuantity = currentQuantity + transaction.getQuantity();
        Storage.storage.put(key,newQuantity);
    }
}

