package core.basesyntax.service.operation.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationType;

public class PurchaseOperationImpl implements OperationType {

    @Override
    public void handle(String line) {
        String[] splitLine = line.split(",");

        String fruitName = splitLine[1];
        String purchaseQuantity = splitLine[2];

        if (Storage.storage.get(fruitName) == null) {
            throw new RuntimeException("there is no value for this key");
        }

        FruitTransaction fruitTransaction = Storage.storage.get(fruitName);
        int fruitTransactionQuantity = fruitTransaction.getQuantity();
        int remainingQuantity = fruitTransactionQuantity - Integer.parseInt(purchaseQuantity);
        fruitTransaction.setQuantity(remainingQuantity);
        fruitTransaction.setBoughtStatus(true);
    }
}
