package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(Fruit fruit) {
        Storage.listOfFruits.add(fruit);
    }

    @Override
    public Fruit get(String fruitName) {
        return Storage.listOfFruits.stream()
                .filter(fruit -> fruit.getName().equals(fruitName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Fruit fruit) {
        Fruit fruitFromDb = get(fruit.getName());
        Storage.listOfFruits.remove(fruitFromDb);
        add(fruit);
    }
}
