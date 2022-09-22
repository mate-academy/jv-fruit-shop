package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashMap;

public class Storage {
    private static HashMap<Fruit, Integer> fruits = new HashMap<>();

    public static HashMap<Fruit, Integer> getFruits() {
        return fruits;
    }

    public static void setFruits(HashMap<Fruit, Integer> fruits) {
        Storage.fruits = fruits;
    }
}
