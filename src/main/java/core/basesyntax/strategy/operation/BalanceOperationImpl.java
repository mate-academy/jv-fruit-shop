package core.basesyntax.strategy.operation;

import core.basesyntax.storage.Store;

public class BalanceOperationImpl implements OperationHandler {
    @Override
    public void getResultBalance(String fruitName, int value) {
        Store.FRUIT_STORAGE.put(fruitName, value);
    }
}
