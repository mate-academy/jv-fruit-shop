package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;
import java.util.Set;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void put(String fruit, Integer quantity) {
        Storage.fruits.put(fruit, quantity);
    }

    @Override
    public void subtract(String fruit, int quantity) {
        if (quantity > Storage.fruits.get(fruit)) {
            throw new RuntimeException("We can't sell you more than "
                    + Storage.fruits.get(fruit));
        }
        Storage.fruits.put(fruit, Storage.fruits.get(fruit) - quantity);
    }

    @Override
    public void addition(String fruit, int quantity) {
        Storage.fruits.put(fruit, Storage.fruits.get(fruit) + quantity);
    }

    @Override
    public Set<Map.Entry<String, Integer>> getEntries() {
        return Storage.fruits.entrySet();
    }
}
