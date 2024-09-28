package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.StorageService;

public class StorageServiceImpl implements StorageService {
    @Override
    public void decrement(Fruit fruit, int quantity) {
        int currentQuantity = Storage.fruitInventory.getOrDefault(fruit, 0);
        if (currentQuantity < quantity) {
            throw new IllegalArgumentException("Not enough " + fruit + " in storage");
        }
        Storage.fruitInventory.put(fruit, currentQuantity - quantity);
    }

    @Override
    public void increment(Fruit fruit, int quantity) {
        int currentQuantity = Storage.fruitInventory.getOrDefault(fruit, 0);
        Storage.fruitInventory.put(fruit, currentQuantity + quantity);
    }

    @Override
    public int getQuantity(Fruit fruit) {
        return Storage.fruitInventory.getOrDefault(fruit, 0);
    }
}
