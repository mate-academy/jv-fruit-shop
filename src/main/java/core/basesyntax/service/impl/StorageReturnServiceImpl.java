package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.StorageUpdateService;

public class StorageReturnServiceImpl implements StorageUpdateService {
    @Override
    public Fruit update(Fruit fruit, Integer amount) {
        return new StorageSupplyServiceImpl().update(fruit, amount);
    }
}
