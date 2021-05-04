package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class FruitDataBase {
    private static final Map<Fruit, Integer> fruitMap = new HashMap<>();

    public static Map<Fruit, Integer> getFruitMap() {
        return fruitMap;
    }
}
