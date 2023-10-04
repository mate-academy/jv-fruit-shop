package core.basesyntax.operation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Storage;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void set(FruitTransaction fruitTransaction) {
        Storage.fruits.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
