package core.basesyntax.strategy.handlerimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperation implements OperationHandler {
    @Override
    public void operate(FruitTransaction fruitTransaction) {
        int quantity = fruitTransaction.getQuantity();
        String fruit = fruitTransaction.getFruit();
        if (quantity < 0) {
            throw new RuntimeException("Invalid quantity of fruit " + quantity);
        }
        Storage.fruitStorage.put(fruit, quantity);
    }
}
