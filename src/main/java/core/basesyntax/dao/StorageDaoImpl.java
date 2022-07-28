package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.List;

public class StorageDaoImpl implements StorageDao {

    @Override
    public void addToStorage(Fruit fruit) {
        Storage.fruits.add(fruit);
    }

    @Override
    public Fruit getFromStorage(String fruitType) {
        return Storage.fruits.stream()
                .filter(fruit -> fruit.getFruitType().equals(fruitType))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public void updateStorage(Fruit fruit) {
        Fruit fromStorage = getFromStorage(fruit.getFruitType());
        fromStorage.setFruitQuantity(fruit.getFruitQuantity());
    }

    @Override
    public List<Fruit> getAllFruits() {
        return Storage.fruits;
    }
}
