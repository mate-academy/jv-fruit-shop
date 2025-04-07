package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ShopDataBase {
    private static Map<String,Integer> shopData = new HashMap<>();

    public static Set<Map.Entry<String, Integer>> getMapEntrySet() {
        return shopData.entrySet();
    }

    public static void put(String key, Integer value) {
        shopData.put(key,value);
    }

    public static Integer getValue(String key) {
        return shopData.get(key);
    }
}
