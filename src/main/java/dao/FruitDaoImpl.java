package dao;

import model.Fruit;
import db.Storage;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit) {
        Storage.fruits.add(fruit);
    }

    @Override
    public Fruit get(String fruitName) {
        return Storage.fruits.stream()
                .filter(f -> f.getName().equals(fruitName))
                .findFirst()
                .get();
    }

    @Override
    public void update(Fruit fruit) {
        Fruit fruitFromDB = get(fruit.getName());
        Storage.fruits.remove(fruitFromDB);
        add(fruit);
    }
}
