package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void performOperation(String fruit, int quantity) {
        if (Storage.fruits.put(fruit, quantity) != null) {
            throw new RuntimeException("Incorrect balance operation. Balance of " + fruit
                    + " have been already set!");
        }
    }
}
