package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {

    @Override
    public Map<String, Integer> getStorage() {
        return Storage.fruitsStorage;
    }

    @Override
    public Integer get(String key) {
        return Storage.fruitsStorage.get(key);
    }

    @Override
    public void add(String name, Integer quantity) {
        Storage.fruitsStorage.put(name, quantity);
    }
}
