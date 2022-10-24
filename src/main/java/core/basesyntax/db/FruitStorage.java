package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class FruitStorage {
    public static final Map<LocalDate, Map<Fruit, Integer>> fruitStorage = new HashMap<>();
}
