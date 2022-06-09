package core.basesyntax.db;

import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public Map<String, Integer> getStorage() {
        return Storage.storage;
    }
}
