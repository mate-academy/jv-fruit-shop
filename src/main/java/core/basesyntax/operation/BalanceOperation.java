package core.basesyntax.operation;

import core.basesyntax.FruitTransaction;
import core.basesyntax.db.Storage;

public class BalanceOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        Storage.fruitStorage.put(fruit, Storage.fruitStorage.getOrDefault(fruit, 0)
                + transaction.getQuantity());
    }
}
