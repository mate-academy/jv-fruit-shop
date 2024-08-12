package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> quantities = new HashMap<>();

    public void addQuantity(FruitTransaction fruitTransaction) {
        quantities.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }

    public int getQuantity(String fruit) {
        return quantities.getOrDefault(fruit, 0);
    }
}
