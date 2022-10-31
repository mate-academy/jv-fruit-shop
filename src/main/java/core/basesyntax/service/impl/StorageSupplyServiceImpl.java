package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.StorageUpdateService;

public class StorageSupplyServiceImpl implements StorageUpdateService {
    @Override
    public Fruit update(Fruit fruit, Integer amount) {
        Integer totalAmount = amount;
        if (Storage.storage.containsKey(fruit)) {
            totalAmount = Storage.storage.get(fruit) + amount;
        }
        Storage.storage.put(fruit, totalAmount);
        return fruit;
    }
}
