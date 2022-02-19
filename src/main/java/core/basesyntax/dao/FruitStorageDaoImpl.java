package core.basesyntax.dao;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;
import java.util.List;

public class FruitStorageDaoImpl implements FruitStorageDao {
    @Override
    public Fruit add(Fruit fruit) {
        FruitStorage.fruit.add(fruit);
        return fruit;
    }

    @Override
    public Fruit get(String name) {
        return FruitStorage.fruit.stream()
                .filter(f -> f.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(name + " not found!!"));
    }

    @Override
    public List<Fruit> getAll() {
        return FruitStorage.fruit;
    }
}
