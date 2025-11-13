package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int current = Storage.getOrDefault(fruit, 0);
        Storage.put(fruit, current + transaction.getQuantity());
    }
}
