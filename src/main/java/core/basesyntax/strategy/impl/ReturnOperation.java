package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.HashMap;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(HashMap<String, Integer> storage, FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        if (quantity < 0) {
            throw new RuntimeException(String.format("Error returning "
                    + "fruit %s: quantity of returning %d is less than zero", fruit, quantity));

        }
        storage.put(fruit, (storage.get(fruit) + quantity));
    }
}
