package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.ArrayList;
import java.util.List;

public class FruitsStorage {
    private static List<Fruit> fruits = new ArrayList<>();

    public static List<Fruit> getFruits() {
        return fruits;
    }

    public static void setFruits(List<Fruit> fruits) {
        FruitsStorage.fruits = fruits;
    }
}
