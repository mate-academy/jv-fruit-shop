package strategy.impl;

import database.Storage;
import strategy.OperationHandler;

public class BalanceHandler implements OperationHandler {
    @Override
    public void doTransaction(String fruit, int value) {
        Storage.STORAGE.put(fruit, value);
    }
}
