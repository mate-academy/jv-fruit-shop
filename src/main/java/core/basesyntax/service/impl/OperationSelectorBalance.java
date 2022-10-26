package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageAccess;
import core.basesyntax.service.OperationSelector;

public class OperationSelectorBalance extends StorageAccess implements OperationSelector {
    @Override
    public void valueOperation(String key, int value) {
        storage.addFruit(key, value);
    }
}
