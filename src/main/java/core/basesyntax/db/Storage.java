package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruits = new HashMap<>();

    public void addFruits(FruitTransaction fruitTransaction) {
        fruits.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }

    public static Map<String, Integer> getAllFruits() {
        return fruits;
    }
}
