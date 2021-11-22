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
        for (Fruit fruit : LocalStorage.fruits) {
            if (fruit.getName().equals(name)) {
                return fruit;
            }
        }
        return null;
    }
}
