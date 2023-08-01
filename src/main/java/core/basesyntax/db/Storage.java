package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;

import java.util.*;

public class Storage {
    public static final List<FruitTransaction> transactionStorage = new ArrayList<>();
    public static final Map<String, Integer> fruitStorage =  new HashMap<>();
}
