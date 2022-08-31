package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void put(Fruit fruit, int quantity) {
        Storage.fruits.put(fruit, quantity);
    }

    @Override
    public void addQuantity(Fruit fruit, int quantity) {
        Storage.fruits.put(fruit, Storage.fruits.get(fruit) + quantity);
    }

    @Override
    public void subtract(Fruit fruit, int quantity) {
        if (quantity > Storage.fruits.get(fruit)) {
            throw new RuntimeException("Not enough fruits in shop");
        }
        Storage.fruits.put(fruit, Storage.fruits.get(fruit) - quantity);
    }

    @Override
    public int get(Fruit fruit) {
        return Storage.fruits.get(fruit);
    }
}
