package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        Storage.fruits.put(fruit, Storage.fruits.get(fruit) + transaction.getQuantity());
    }
}
