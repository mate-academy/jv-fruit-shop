package strategy.impl;

import database.Storage;
import strategy.OperationHandler;

public class ReturnHandler implements OperationHandler {
    @Override
    public void doTransaction(String fruit, int value) {
        int oldValue = Storage.STORAGE.get(fruit);
        Storage.STORAGE.put(fruit, oldValue + value);
    }
}
