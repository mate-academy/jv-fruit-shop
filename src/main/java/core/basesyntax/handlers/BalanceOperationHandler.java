package core.basesyntax.handlers;

import core.basesyntax.storage.Storage;
import core.basesyntax.transaction.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public void performOperation(FruitTransaction fruitTransaction) {
        Storage.getFruitBalance().put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
