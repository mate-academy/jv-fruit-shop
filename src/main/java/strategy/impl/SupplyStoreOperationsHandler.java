package strategy.impl;

import model.FruitTransaction;
import storage.Storage;
import strategy.StoreOperationsHandler;

public class SupplyStoreOperationsHandler implements StoreOperationsHandler {
    @Override
    public void useOperation(FruitTransaction transaction) {
        int balance = Storage.getStorage().get(transaction.getName());
        int supply = balance + transaction.getQuantity();
        Storage.getStorage().put(transaction.getName(), supply);
    }
}
