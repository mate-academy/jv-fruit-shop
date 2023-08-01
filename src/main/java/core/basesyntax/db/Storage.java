package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    public static final List<FruitTransaction> transactionStorage = new ArrayList<>();
    public static final Map<String, Integer> fruitStorage = new HashMap<>();
}
