package core.basesyntax.db;

import core.basesyntax.domain.Fruit;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static List<Fruit> fruits = new ArrayList<>();

    public static List<Fruit> getFruits() {
        return fruits;
    }
}
