package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Storage;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        int current = Storage.getStorage().getOrDefault(fruit, 0);
        Storage.getStorage().put(fruit, current + quantity);
    }
}
