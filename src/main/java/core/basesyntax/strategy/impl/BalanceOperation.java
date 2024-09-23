package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

import java.util.HashMap;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(HashMap storage, FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        if (quantity < 0) {
            throw new RuntimeException(String.format("Error setting balance "
                    + "of the fruit %s: quantity %d is less than zero", fruit, quantity));
        }
        storage.put(fruit, quantity);
    }
}
