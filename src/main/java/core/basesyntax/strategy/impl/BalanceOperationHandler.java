package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void makeTransaction(String fruits, int number) {
        Storage.fruits.put(fruits, number);
    }
}
