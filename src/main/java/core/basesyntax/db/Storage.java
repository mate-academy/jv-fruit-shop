package core.basesyntax.db;

import core.basesyntax.model.FruitInStorage;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, FruitInStorage> FRUITS = new HashMap<>();

    public void add(FruitInStorage product) {
        FRUITS.put(product.getName(), product);
    }

    public FruitInStorage getByName(String name) {
        return FRUITS.get(name);
    }

    public void update(FruitInStorage product, int amount) {
        product.setAmount(amount);
        FRUITS.put(product.getName(), product);
    }

    public Collection<FruitInStorage> getAll() {
        return FRUITS.values();
    }
}
