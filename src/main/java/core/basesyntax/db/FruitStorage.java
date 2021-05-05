package core.basesyntax.db;

import core.basesyntax.fruitmodel.Fruit;
import java.util.HashMap;
import java.util.Map;

public class FruitStorage {
    private static Map<Fruit, Integer> fruitStorage = new HashMap<>();

    public Map<Fruit, Integer> getFruitStorage() {
        return fruitStorage;
    }
}
