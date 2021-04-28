package fruitshop.db;

import fruitshop.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class FruitStorage {
    private static Map<Fruit, Integer> fruitMap = new HashMap<>();

    public static Map<Fruit, Integer> getFruitMap() {
        return fruitMap;
    }
}
