package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class PurchaseHandler implements OperationHandler {
    @Override
    public Map<String, Integer> handleOperation(FruitTransaction transaction,
                                                Map<String, Integer> fruitQuantities) {
        String fruit = transaction.getFruit().getName();
        int quantity = transaction.getQuantity();
        if (fruitQuantities.getOrDefault(fruit, 0) - quantity < 0) {
            throw new RuntimeException("Not enough of " + fruit + " to perform this operation");
        }
        fruitQuantities.put(fruit, fruitQuantities.getOrDefault(fruit, 0) - quantity);
        return fruitQuantities;
    }
}
