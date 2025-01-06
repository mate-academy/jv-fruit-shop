package strategy.impl;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void doOperation(FruitTransaction transaction) {
        int currentQuantity = Storage.getDb().get(transaction.getFruit());
        if (currentQuantity - transaction.getQuantity() > 0) {
            Storage.getDb().put(transaction.getFruit(),
                    currentQuantity - transaction.getQuantity());
        }
    }
}
