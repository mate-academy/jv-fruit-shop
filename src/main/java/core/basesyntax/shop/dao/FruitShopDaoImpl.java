package core.basesyntax.shop.dao;

import core.basesyntax.shop.db.FruitShopStorage;
import core.basesyntax.shop.model.Fruit;
import java.util.Map;

public class FruitShopDaoImpl implements FruitShopDao {
    @Override
    public void add(Fruit fruit, int quantity) {
        Map<Fruit, Integer> fruits = FruitShopStorage.getAll();
        if (fruits.containsKey(fruit)) {
            fruits.put(fruit, fruits.get(fruit) + quantity);
        } else {
            fruits.put(fruit, quantity);
        }
    }

    @Override
    public void subtract(Fruit fruit, int quantity) throws InsufficientGoodsException {
        Map<Fruit, Integer> fruits = FruitShopStorage.getAll();
        if (fruits.containsKey(fruit) && fruits.get(fruit) > quantity) {
            fruits.put(fruit, fruits.get(fruit) - quantity);
            return;
        }
        throw new InsufficientGoodsException("Not enough " + fruit.getName());
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return FruitShopStorage.getAll();
    }
}
