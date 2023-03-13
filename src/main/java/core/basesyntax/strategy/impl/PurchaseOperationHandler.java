package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        if (transaction.getOperation().equals(FruitTransaction.Operation.PURCHASE)) {
            int quantity = Storage.fruits.get(transaction.getFruit());
            if (quantity >= transaction.getQuantity()) {
                Storage.fruits.put(transaction.getFruit(), transaction.getQuantity() - quantity);
            } else {
            //    Storage.fruits.put(transaction.getFruit(), transaction.getQuantity());
           //Todo

            }
        }
    }
}
