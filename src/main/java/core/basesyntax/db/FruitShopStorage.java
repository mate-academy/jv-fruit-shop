package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class FruitShopStorage {
    private static Map<String, Integer> fruitShopStorage = new HashMap<>();

    public Map<String, Integer> getFruitShopStorage() {
        return this.fruitShopStorage;
    }

    public void setFruitShopStorage(Map<String, Integer> fruitShopStorage) {
        this.fruitShopStorage = fruitShopStorage;
    }

    public void put(String key, Integer value) {
        fruitShopStorage.put(key, value);
    }

    public int getQuantity(String key) {
        if (fruitShopStorage.containsKey(key)) {
            return fruitShopStorage.get(key);
        } else {
            throw new IllegalArgumentException("This fruit is absent - " + key);
        }

    }
}
