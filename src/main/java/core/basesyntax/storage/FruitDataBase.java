package core.basesyntax.storage;

import java.util.HashMap;
import java.util.Map;

public class FruitDataBase {
    private final Map<String, Integer> fruitShopData;

    public FruitDataBase() {
        fruitShopData = new HashMap<>();
    }

    public Integer getFruitShopData(String key) {
        return fruitShopData.get(key);
    }

    public Map<String, Integer> getDataBaseCopy() {
        return new HashMap<>(fruitShopData);
    }

    public void setFruitShopData(String key, Integer value) {
        fruitShopData.put(key, value);
    }
}
