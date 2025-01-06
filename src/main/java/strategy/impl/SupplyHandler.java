package strategy.impl;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class SupplyHandler implements OperationHandler {
    @Override
    public void doOperation(FruitTransaction transaction) {
        int currentQuantity = Storage.getDb().get(transaction.getFruit());
        Storage.getDb().put(transaction.getFruit(),
                currentQuantity + transaction.getQuantity());
    }
}
