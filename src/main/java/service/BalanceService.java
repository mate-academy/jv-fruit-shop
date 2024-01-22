package service;

import model.FruitTransaction;
import storage.Storage;

public class BalanceService implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        Storage.getFruitsStorage().put(transaction.getName(), transaction.getQuantity());
    }
}
