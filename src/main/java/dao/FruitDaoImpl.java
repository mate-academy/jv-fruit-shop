package dao;

import bd.LocalStorage;
import java.util.List;
import java.util.Optional;
import model.Fruit;

public class FruitDaoImpl implements FruitDao {
    @Override
    public List<Fruit> getAll() {
        return LocalStorage.fruits;
    }

    @Override
    public boolean add(Fruit fruit) {
        LocalStorage.fruits.add(fruit);
        return true;
    }

    @Override
    public Optional<Fruit> get(String name) {
        for (Fruit fruit : LocalStorage.fruits) {
            if (fruit.getName().equals(name)) {
                return Optional.of(fruit);
            }
        }
        return Optional.empty();
    }
}
