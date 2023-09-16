package strategy.impl;

import model.FruitTransaction;
import storage.Storage;
import strategy.StoreOperationsHandler;

public class BalanceStoreOperationsHandler implements StoreOperationsHandler {

    @Override
    public void useOperation(FruitTransaction transaction) {
        Storage.getStorage().put(transaction.getName(), transaction.getQuantity());
    }
}
