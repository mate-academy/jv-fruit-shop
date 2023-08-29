package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void operateTransaction(FruitTransaction fruitTransaction) {
        Storage.totalFruit.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
