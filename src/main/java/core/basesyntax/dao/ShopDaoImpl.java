package core.basesyntax.dao;

import core.basesyntax.dp.Shop;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class ShopDaoImpl implements ShopDao {
    @Override
    public void add(Fruit fruit, int amount) {
        Shop.fruits.put(fruit, amount);
    }

    @Override
    public Map<Fruit, Integer> getFruits() {
        return Shop.fruits;
    }

}
