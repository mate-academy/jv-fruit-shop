package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        String key = transaction.getFruit();
        if (!Storage.DATABASE.containsKey(key)) {
            //just some logic
            throw new RuntimeException("No such fruit in shop");
        }
        int newQuantity = transaction.getQuantity() + Storage.DATABASE.get(key);
        Storage.DATABASE.put(key, newQuantity);
    }
}
