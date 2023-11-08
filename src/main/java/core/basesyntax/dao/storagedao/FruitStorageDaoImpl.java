package core.basesyntax.dao.storagedao;

import core.basesyntax.db.FruitStorage;

import java.util.HashMap;
import java.util.Map;

public class FruitStorageDaoImpl implements FruitStorageDao {
    @Override
    public void putToStorage(String name, Integer quantity) {
        FruitStorage.fruitDB.put(name, quantity);
    }

    @Override
    public void removeToStorage(String name) {
        FruitStorage.fruitDB.remove(name);
    }

    @Override
    public Integer get(String name) {
        return FruitStorage.fruitDB.get(name);
    }

    @Override
    public Map<String, Integer> getAllStorage() {
        return new HashMap<>(FruitStorage.fruitDB);
    }

    @Override
    public boolean containsKey(String name) {
        return FruitStorage.fruitDB.containsKey(name);
    }
}
