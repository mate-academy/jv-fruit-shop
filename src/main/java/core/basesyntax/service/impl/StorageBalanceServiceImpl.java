package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.StorageUpdateService;

public class StorageBalanceServiceImpl implements StorageUpdateService {
    @Override
    public Fruit update(Fruit fruit, Integer amount) {
        Storage.storage.put(fruit, amount);
        return fruit;
    }
}
