package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageAccess;
import core.basesyntax.service.OperationSelector;

public class OperationSelectorPurchase extends StorageAccess implements OperationSelector {
    @Override
    public void valueOperation(String key, int value) {
        storage.modifyValue(key, storage.get(key) - value);
    }
}
