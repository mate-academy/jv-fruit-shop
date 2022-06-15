package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void update(String key, int value) {
        Storage.fruitsAvailable.put(key, value);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.fruitsAvailable;
    }

    @Override
    public int get(String key) {
        return Storage.fruitsAvailable.get(key) == null ? 0 : Storage.fruitsAvailable.get(key);
    }
}
