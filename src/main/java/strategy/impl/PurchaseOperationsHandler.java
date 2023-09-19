package strategy.impl;

import model.FruitTransaction;
import storage.Storage;
import strategy.OperationsHandler;

public class PurchaseOperationsHandler implements OperationsHandler {
    @Override
    public void useOperation(FruitTransaction transaction) {
        int balance = Storage.getStorage().get(transaction.getName());
        int purchase = balance - transaction.getQuantity();
        Storage.getStorage().put(transaction.getName(), purchase);
    }
}
