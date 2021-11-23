package dao;

import bd.LocalStorage;
import java.util.List;
import model.Fruit;

public class FruitDaoImpl implements FruitDao {
    @Override
    public List<Fruit> getListRemainder() {
        return LocalStorage.fruits;
    }

    @Override
    public boolean add(Fruit fruit) {
        LocalStorage.fruits.add(fruit);
        return true;
    }

    @Override
    public Fruit getByName(String name) {
        return LocalStorage.fruits.stream()
                .filter(f -> f.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
