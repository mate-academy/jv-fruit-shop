package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Storage storage) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        int current = storage.getOrDefault(fruit, 0);
        storage.put(fruit, current + quantity);
    }
}
