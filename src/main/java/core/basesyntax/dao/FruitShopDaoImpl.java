package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class FruitShopDaoImpl implements FruitShopDao {

    @Override
    public void add(Fruit fruit) {
        Storage.fruits.add(fruit);
    }

    @Override
    public Fruit get(Fruit.TYPE type) {
        return Storage.fruits.stream()
                .filter(a -> a.getType().equals(type))
                .findFirst()
                .get();
    }
}
