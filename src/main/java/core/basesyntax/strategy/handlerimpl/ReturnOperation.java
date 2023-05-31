package core.basesyntax.strategy.handlerimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperation implements OperationHandler {
    @Override
    public void operate(FruitTransaction fruitTransaction) {
        int quantity = fruitTransaction.getQuantity();
        String fruit = fruitTransaction.getFruit();
        int oldQuantity = Storage.fruitStorage.getOrDefault(fruit, 0);
        if (quantity < 0) {
            throw new RuntimeException("Invalid quantity of fruit " + quantity);
        }
        Storage.fruitStorage.put(fruit, oldQuantity + quantity);
    }
}
