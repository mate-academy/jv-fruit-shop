package core.basesyntax.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruits = transaction.getFruit();
        int quantity = transaction.getQuantity();
        Storage.fruits.put(fruits, quantity);
    }
}
