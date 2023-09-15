package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        if (!Storage.DATA_BASE.containsKey(transaction.getFruit())) {
            //just some logic
            throw new RuntimeException("No such fruit in shop");
        }
        int newQuantity = transaction.getQuantity() + Storage.DATA_BASE.get(transaction.getFruit());
        Storage.DATA_BASE.put(transaction.getFruit(), newQuantity);
    }
}
