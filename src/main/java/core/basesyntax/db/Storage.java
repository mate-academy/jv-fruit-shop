package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    public static final Map<Fruit, List<FruitTransaction>> fruitTransactions = new HashMap<>();
    public static final Map<Fruit, Integer> fruitBalance = new HashMap<>();
}
