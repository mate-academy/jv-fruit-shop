package service.impl;

import model.FruitTransaction;
import service.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Storage storage) {
        String fruit = transaction.getFruit();
        int currentBalance = storage.getQuantity(fruit);
        int updatedBalance = currentBalance + transaction.getQuantity();
        if (updatedBalance < 0) {
            throw new RuntimeException("Negative balance for " + fruit + " - " + updatedBalance);
        }
        storage.updateStorage(fruit, transaction.getQuantity());
    }
}
