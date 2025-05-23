package core.basesyntax.operation.impl;

import core.basesyntax.model.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        if (!FruitStorage.getStorage().containsKey(fruit)) {
            FruitStorage.getStorage().put(fruit, transaction.getQuantity());
            return;
        }
        FruitStorage.getStorage()
                .put(fruit, FruitStorage.getStorage()
                        .get(fruit) + transaction.getQuantity());
    }
}
