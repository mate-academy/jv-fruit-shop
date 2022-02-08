package core.basesyntax.shop.dao;

import core.basesyntax.shop.model.Fruit;
import java.util.Map;

public interface FruitShopDao {
    void add(Fruit fruit, int quantity);

    void subtract(Fruit fruit, int quantity) throws InsufficientGoodsException;

    Map<Fruit, Integer> getAll();
}
