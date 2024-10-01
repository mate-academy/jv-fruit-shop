package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.StorageService;

public class StorageServiceImpl implements StorageService {
    @Override
    public void addFruit(Fruit fruit, int quantity) {
        int currentQuantity = Storage.getFruitQuiantity(fruit);
        Storage.updateFruitQuantity(fruit, currentQuantity + quantity);
    }

    @Override
    public void removeFruit(Fruit fruit, int quantity) {
        int currentQuantity = Storage.getFruitQuiantity(fruit);
        if (currentQuantity < quantity) {
            throw new IllegalArgumentException("Not enough " + fruit.getName()
                    + " in storage to remove");
        }
        Storage.updateFruitQuantity(fruit, currentQuantity - quantity);
    }

    @Override
    public int getQuantity(Fruit fruit) {
        return Storage.getFruitQuiantity(fruit);
    }
}
