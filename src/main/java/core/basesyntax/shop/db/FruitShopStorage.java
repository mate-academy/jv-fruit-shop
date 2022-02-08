package core.basesyntax.shop.db;

import core.basesyntax.shop.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class FruitShopStorage {
    private static final Map<Fruit, Integer> FRUIT_SHOP_MAP = new HashMap<>();

    public static Map<Fruit, Integer> getAll() {
        return FRUIT_SHOP_MAP;
    }
}
