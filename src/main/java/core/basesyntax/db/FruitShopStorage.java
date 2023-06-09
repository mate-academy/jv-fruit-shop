package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class FruitShopStorage {
    private Map<String, Integer> fruitShopStorage;

    public FruitShopStorage() {
        this.fruitShopStorage = new HashMap<String, Integer>();
    }

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
        return fruitShopStorage.get(key);
    }
}
