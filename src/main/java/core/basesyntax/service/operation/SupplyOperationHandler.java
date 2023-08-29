package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void operateTransaction(FruitTransaction fruitTransaction) {
        int oldQuantity = Storage.totalFruit.get(fruitTransaction.getFruit());
        Storage.totalFruit.put(fruitTransaction.getFruit(),
                oldQuantity + fruitTransaction.getQuantity());
    }
}
