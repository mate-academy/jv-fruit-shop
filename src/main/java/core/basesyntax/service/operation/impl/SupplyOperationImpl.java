package core.basesyntax.service.operation.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationType;

public class SupplyOperationImpl implements OperationType {

    @Override
    public void handle(String line) {
        String[] splitLine = line.split(",");

        String fruitName = splitLine[1];
        String supplyQuantity = splitLine[2];

        if (Storage.storage.containsKey(fruitName)) {
            FruitTransaction fruitTransaction = Storage.storage.get(fruitName);

            int fruitTransactionQuantity = fruitTransaction.getQuantity();
            int totalQuantity = Integer.parseInt(supplyQuantity) + fruitTransactionQuantity;
            fruitTransaction.setQuantity(totalQuantity);
        }
    }
}
