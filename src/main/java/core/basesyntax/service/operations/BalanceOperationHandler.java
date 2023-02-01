package core.basesyntax.service.operations;

import core.basesyntax.database.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void proceedOperation(FruitTransaction fruitTransaction) {
        Storage.fruits.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
