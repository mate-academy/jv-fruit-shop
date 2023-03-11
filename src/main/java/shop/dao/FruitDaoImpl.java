package shop.dao;

import java.util.List;
import shop.db.DataStorage;
import shop.model.Fruit;

public class FruitDaoImpl implements FruitDao {
    @Override
    public List<Fruit> getAll() {
        return DataStorage.storage;
    }

    @Override
    public boolean add(Fruit fruit) {
        return DataStorage.storage.add(fruit);
    }

    @Override
    public Fruit get(String name) {
        return DataStorage.storage.stream()
                .filter(f -> f.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
