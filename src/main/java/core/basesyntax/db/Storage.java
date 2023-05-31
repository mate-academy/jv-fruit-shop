package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> fruits = new HashMap<>();
    public static final List<FruitTransaction> transactions = new ArrayList<>();
}
