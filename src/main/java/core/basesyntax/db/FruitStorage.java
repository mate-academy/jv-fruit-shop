package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashSet;
import java.util.Set;

public class FruitStorage {
    private static final Set<Fruit> fruits = new HashSet<>();

    public static Set<Fruit> getFruits() {
        return fruits;
    }
}
