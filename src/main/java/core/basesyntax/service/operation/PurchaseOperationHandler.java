package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void operateTransaction(FruitTransaction fruitTransaction) {
        int oldQuantity = Storage.totalFruit.get(fruitTransaction.getFruit());
        if (oldQuantity < fruitTransaction.getQuantity()) {
            throw new RuntimeException("Not enough " + fruitTransaction.getFruit()
                    + " for purchase");
        }
        Storage.totalFruit.put(fruitTransaction.getFruit(),
                oldQuantity - fruitTransaction.getQuantity());
    }
}
