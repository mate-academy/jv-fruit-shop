package strategy.impl;

import model.FruitTransaction;
import storage.Storage;
import strategy.OperationsHandler;

public class BalanceOperationsHandler implements OperationsHandler {

    @Override
    public void useOperation(FruitTransaction transaction) {
        Storage.getStorage().put(transaction.getName(), transaction.getQuantity());
    }
}
