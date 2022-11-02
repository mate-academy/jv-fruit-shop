package core.basesyntax.strategy.operation.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.operation.OperationHandler;

public class BalanceOperationImpl implements OperationHandler {
    @Override
    public void getResultBalance(String fruitName, int value) {
        if (Storage.FRUIT_STORAGE.get(fruitName) == null) {
            Storage.FRUIT_STORAGE.put(fruitName, value);
            return;
        }
        int oldVale = Storage.FRUIT_STORAGE.get(fruitName);
        int newValue = oldVale + value;
        Storage.FRUIT_STORAGE.put(fruitName, newValue);
    }
}
