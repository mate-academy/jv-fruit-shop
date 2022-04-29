package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;
import java.util.HashMap;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(Fruit fruit, Integer quantity) {
        if (Storage.fruitStorage.get(fruit) == null) {
            Storage.fruitStorage.put(fruit, quantity);
        } else {
            Storage.fruitStorage.replace(fruit, getFruitQuantity(fruit) + quantity);
        }
    }

    @Override
    public void remove(Fruit fruit, Integer quantity) {
        Storage.fruitStorage.replace(fruit, getFruitQuantity(fruit) - quantity);
    }

    @Override
    public int getFruitQuantity(Fruit fruit) {
        return Storage.fruitStorage.get(fruit);
    }

    @Override
    public HashMap<Fruit, Integer> getStorage() {
        return new HashMap<>(Storage.fruitStorage);
    }
}
