package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    public static final List<FruitTransaction> dataFromFile = new ArrayList<>();
    public static final Map<Fruit, Integer> storage = new HashMap<>();
}
