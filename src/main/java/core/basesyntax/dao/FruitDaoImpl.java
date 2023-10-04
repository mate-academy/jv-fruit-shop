package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(String key, Integer quantity) {
        Storage.getFruitsStorage().put(key, quantity);
    }

    @Override
    public Map<String, Integer> getStorage() {
        return Storage.getFruitsStorage();
    }
}
