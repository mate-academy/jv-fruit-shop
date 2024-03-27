package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;
import java.util.Set;

public class FruitTransactionDaoImpl implements FruitTransactionDao {
    @Override
    public void add(String name, Integer quantity) {
        if (Storage.fruits.get(name) == null) {
            Storage.fruits.put(name, quantity);
        } else {
            update(name, quantity);
        }
    }

    @Override
    public void update(String name, Integer quantity) {
        Storage.fruits.replace(name, quantity);
    }

    @Override
    public int getByName(String name) {
        return Storage.fruits.get(name);
    }

    @Override
    public Set<Map.Entry<String, Integer>> getFull() {
        return Storage.fruits.entrySet();
    }
}
