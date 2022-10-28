package core.basesyntax.service.impl;

import core.basesyntax.storage.Store;
import core.basesyntax.strategy.OperationStrategyImpl;

public class BalanceOperationStrategyImpl implements OperationStrategyImpl {
    @Override
    public void getResultBalance(String fruitName, int value) {
        Store.FRUIT_STORAGE.put(fruitName, value);
    }
}
