package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int currentQuantity = Storage.fruitStorage.getOrDefault(fruit, 0);
        Storage.fruitStorage.put(fruit, currentQuantity + transaction.getQuantity());
    }
}
