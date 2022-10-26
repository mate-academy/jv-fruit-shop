package core.basesyntax.dao;

import core.basesyntax.db.FruitStorage;
import java.util.HashMap;

public class FruitStorageDaoImpl implements FruitStorageDao {
    @Override
    public void addFruit(String key, Integer value) {
        FruitStorage.fruitStorage.put(key, value);
    }

    @Override
    public void modifyValue(String key, Integer value) {
        FruitStorage.fruitStorage.replace(key, value);
    }

    @Override
    public Integer get(String key) {
        return FruitStorage.fruitStorage.get(key);
    }

    @Override
    public HashMap<String, Integer> getStorage() {
        return FruitStorage.fruitStorage;
    }
}
