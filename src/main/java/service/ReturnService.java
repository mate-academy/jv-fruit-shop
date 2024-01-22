package service;

import model.FruitTransaction;
import storage.Storage;

public class ReturnService implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        int currentValue = Storage.getFruitQuantity(transaction);
        Storage.getFruitsStorage().put(transaction.getName(),
                transaction.getQuantity() + currentValue);
    }
}
