package core.basesyntax.shop.dao;

import core.basesyntax.shop.db.FruitShopStorage;
import core.basesyntax.shop.model.Fruit;
import java.util.Map;

public class FruitShopDaoImpl implements FruitShopDao {

    @Override
    public void add(Fruit fruit, int quantity) {
        if (FruitShopStorage.getFruitShopMap().containsKey(fruit)) {
            FruitShopStorage.getFruitShopMap().put(
                    fruit, FruitShopStorage.getFruitShopMap().get(fruit) + quantity);
        } else {
            FruitShopStorage.getFruitShopMap().put(fruit, quantity);
        }
    }

    @Override
    public void subtract(Fruit fruit, int quantity) throws InsufficientGoodsException {
        if (FruitShopStorage.getFruitShopMap().containsKey(fruit)
                && FruitShopStorage.getFruitShopMap().get(fruit) > quantity) {
            FruitShopStorage.getFruitShopMap().put(fruit,
                    FruitShopStorage.getFruitShopMap().get(fruit) - quantity);
            return;
        }
        throw new InsufficientGoodsException("Not enough " + fruit.getName());
    }

    @Override
    public Map<Fruit, Integer> returnMap() {
        return FruitShopStorage.getFruitShopMap();
    }
}
