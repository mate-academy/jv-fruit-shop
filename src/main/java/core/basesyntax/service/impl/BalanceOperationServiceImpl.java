package core.basesyntax.service.impl;

import core.basesyntax.storage.Store;
import core.basesyntax.strategy.OperationService;

public class BalanceOperationServiceImpl implements OperationService {
    @Override
    public void getResultBalance(String fruitName, int value) {
        Store.FRUIT_STORAGE.put(fruitName, value);
    }
}
