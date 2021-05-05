package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Storage {
    public static final String BALANCE = "b";
    public static final String SUPPLY = "s";
    public static final String RETURN = "r";
    public static final String PURCHASE = "p";
    public static final Map<Fruit, Integer> fruits = new HashMap<>();
    public static final Set<String> validOperations = Set.of(BALANCE, SUPPLY, RETURN, PURCHASE);
}

