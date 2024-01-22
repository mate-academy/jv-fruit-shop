package service;

import model.FruitTransaction;
import storage.Storage;

public class PurchaseService implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        int currentValue = Storage.getFruitQuantity(transaction);
        if (currentValue >= transaction.getQuantity()) {
            Storage.getFruitsStorage().put(transaction.getName(),
                    currentValue - transaction.getQuantity());
        }
    }
}
