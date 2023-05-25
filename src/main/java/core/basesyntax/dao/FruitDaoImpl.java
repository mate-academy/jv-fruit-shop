package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit) {
        Storage.storage.add(fruit);
    }

    @Override
    public Fruit get(String fruitType) {
        return Storage.storage.stream()
                .filter(f -> f.getTypeOfFruit().equals(fruitType))
                .findFirst()
                .get();
    }

    @Override
    public List<Fruit> getAll() {
        return Storage.storage;
    }
}
