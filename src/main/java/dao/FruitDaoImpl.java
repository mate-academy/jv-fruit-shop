package dao;

import db.Storage;
import java.util.List;
import shop.item.Fruit;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit) {
        Storage.fruits.add(fruit);
    }

    @Override
    public Fruit get(Fruit fruit) {
        return Storage.fruits.stream()
                .filter(f -> f.getName().equals(fruit.getName()))
                .findFirst().get();
    }

    @Override
    public void update(Fruit fruit) {
        Fruit fruitOld = get(fruit);
        Storage.fruits.remove(fruitOld);
        add(fruit);
    }

    @Override
    public List<Fruit> getAll() {
        return Storage.fruits;
    }
}
