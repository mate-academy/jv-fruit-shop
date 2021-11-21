package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class FruitDaoImpl implements FruitDao {

    @Override
    public Fruit get(String fruitName) {
        return Storage.getStore()
                .stream()
                .filter(f -> f.getName().equals(fruitName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void add(Fruit fruit) {
        Storage.getStore().add(fruit);
    }

    @Override
    public void update(Fruit fruit) {
        Fruit fruitFromStorage = get(fruit.getName());
        Storage.getStore().remove(fruitFromStorage);
        add(fruit);
    }

}
