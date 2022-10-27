package core.basesyntax.service.impl;

import core.basesyntax.storage.Store;
import core.basesyntax.strategy.OperationService;

public class PurchaseOperationServiceImpl implements OperationService {
    @Override
    public void getResultBalance(String fruitName, int value) {
        int oldVale = Store.FRUIT_STORAGE.get(fruitName);
        int newValue = oldVale - value;
        Store.FRUIT_STORAGE.put(fruitName, newValue);
    }
}
