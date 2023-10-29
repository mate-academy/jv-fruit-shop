package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class BalanceHandler implements OperationHandler {
    @Override
    public Map<String, Integer> handleOperation(FruitTransaction transaction,
                                                Map<String, Integer> fruitQuantities) {
        String fruit = transaction.getFruit().getName();
        int quantity = transaction.getQuantity();

        fruitQuantities.put(fruit, quantity);
        return fruitQuantities;
    }
}
