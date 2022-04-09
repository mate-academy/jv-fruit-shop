package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit) {
        Storage.FRUIT_LIST.add(fruit);
    }

    @Override
    public void update(Fruit fruit) {
        Storage.FRUIT_LIST.remove(get(fruit.getName()));
        Storage.FRUIT_LIST.add(fruit);
    }

    @Override
    public Fruit get(String fruitName) {
        return Storage.FRUIT_LIST.stream()
                .filter(name -> fruitName.equals(name.getName()))
                .findFirst()
                .orElse(null);
    }
}
