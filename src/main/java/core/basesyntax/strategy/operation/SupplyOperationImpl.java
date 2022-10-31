package core.basesyntax.strategy.operation;

import core.basesyntax.db.Store;

public class SupplyOperationImpl implements OperationHandler {
    @Override
    public void getResultBalance(String fruitName, int value) {
        int oldVale = Store.FRUIT_STORAGE.get(fruitName);
        int newValue = oldVale + value;
        Store.FRUIT_STORAGE.put(fruitName, newValue);
    }
}
