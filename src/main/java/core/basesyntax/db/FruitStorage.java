package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.EnumMap;
import java.util.Map;

public class FruitStorage {
    public static final Map<Fruit, Integer> fruitsMap = new EnumMap<>(Fruit.class);
}
