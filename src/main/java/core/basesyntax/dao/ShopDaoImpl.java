package core.basesyntax.dao;

import core.basesyntax.dp.Shop;
import java.util.Map;

public class ShopDaoImpl implements ShopDao {
    @Override
    public void add(String fruit, int amount) {
        Shop.fruits.put(fruit, amount);
    }

    @Override
    public Map<String, Integer> getFruits() {
        return Shop.fruits;
    }

}
