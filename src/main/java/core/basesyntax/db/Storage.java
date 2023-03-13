package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> fruitShop = new HashMap<>();

    public static Map<String, Integer> getFruitShop() {
        return fruitShop;
    }

    public static void setFruitShop(Map<String, Integer> fruitShop) {
        Storage.fruitShop = fruitShop;
    }
}
