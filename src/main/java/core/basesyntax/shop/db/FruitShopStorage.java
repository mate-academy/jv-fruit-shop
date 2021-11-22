package core.basesyntax.shop.db;

import java.util.HashMap;
import java.util.Map;

public class FruitShopStorage {
    private static final Map<String, Integer> FRUIT_SHOP_MAP = new HashMap<>();

    public static Map<String, Integer> getFruitShopMap() {
        return FRUIT_SHOP_MAP;
    }
}
