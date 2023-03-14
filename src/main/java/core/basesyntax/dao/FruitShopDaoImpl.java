package core.basesyntax.dao;

import core.basesyntax.db.InputStorage;
import core.basesyntax.model.Fruit;

public class FruitShopDaoImpl implements FruitShopDao {

    @Override
    public void add(Fruit fruit) {
        InputStorage.fruits.add(fruit);
    }

    @Override
    public Fruit get(Fruit.TYPE type) {
        return InputStorage.fruits.stream()
                .filter(a -> a.getType().equals(type))
                .findFirst()
                .get();
    }
}
