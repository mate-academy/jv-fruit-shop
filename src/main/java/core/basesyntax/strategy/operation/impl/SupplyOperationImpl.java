package core.basesyntax.strategy.operation.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.operation.OperationHandler;

public class SupplyOperationImpl implements OperationHandler {
    @Override
    public void getResultBalance(String fruitName, int value) {
        int oldVale = Storage.FRUIT_STORAGE.get(fruitName);
        int newValue = oldVale + value;
        Storage.FRUIT_STORAGE.put(fruitName, newValue);
    }
}
