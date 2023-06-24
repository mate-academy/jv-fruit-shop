package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    public void makeTransaction(String fruits, int number) {
        Storage.fruits.replace(fruits, Storage.fruits.get(fruits) + number);
    }
}
