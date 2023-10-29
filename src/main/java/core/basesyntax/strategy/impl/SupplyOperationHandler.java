package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        if (!Storage.DATABASE.containsKey(transaction.getFruit())) {
            Storage.DATABASE.put(transaction.getFruit(), transaction.getQuantity());
            return;
        }
        int newQuantity = transaction.getQuantity() + Storage.DATABASE.get(transaction.getFruit());
        Storage.DATABASE.put(transaction.getFruit(), newQuantity);
    }
}
