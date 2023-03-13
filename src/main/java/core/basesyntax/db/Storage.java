package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    public static final List<FruitTransaction> listFruitTransactions = new ArrayList<>();
    public static final List<Fruit> listFruits = new ArrayList<>();
    public static final Map<String, Integer> fruits = new HashMap<>();

}
