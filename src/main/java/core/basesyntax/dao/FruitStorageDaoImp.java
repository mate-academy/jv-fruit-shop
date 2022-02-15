package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.ArrayList;
import java.util.List;

public class FruitStorageDaoImp implements FruitStorageDao {

    @Override
    public void add(Fruit fruit) {
        Storage.getFruits().add(fruit);
    }

    @Override
    public Fruit get(String fruitName) {
        return Storage.getFruits().stream()
                .filter(f -> f.getFruitType().equals(fruitName))
                .findFirst()
                .get();
    }

    @Override
    public List<Fruit> getAll() {
        return new ArrayList<>(Storage.getFruits());
    }
}
