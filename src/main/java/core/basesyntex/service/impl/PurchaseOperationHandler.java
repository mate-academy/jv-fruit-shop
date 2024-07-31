package core.basesyntex.service.impl;

import core.basesyntex.model.FruitTransaction;
import core.basesyntex.service.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int currentBalance = Storage.getQuantity(fruit);
        int updatedBalance = currentBalance + transaction.getQuantity();
        if (updatedBalance < 0) {
            throw new RuntimeException("Negative balance for " + fruit + " - " + updatedBalance);
        }
        Storage.updateStorage(fruit, transaction.getQuantity());
    }
}
