package core.basesyntax.storage;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class FruitDataBase {
    private static final Map<Fruit, Integer> fruitData = new HashMap<>();

    public static Map<Fruit, Integer> getFruitData() {
        return fruitData;
    }
}
