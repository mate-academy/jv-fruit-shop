package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public Map<String, Integer> getStorage() {
        return Storage.fruitStorage;
    }

    @Override
    public int getQualityByItemType(String fruit) {
        return Storage.fruitStorage.get(fruit);
    }

    @Override
    public void putToStorage(String fruit, int quality) {
        Storage.fruitStorage.put(fruit, quality);
    }
}
