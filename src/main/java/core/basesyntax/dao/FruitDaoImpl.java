package core.basesyntax.dao;

import core.basesyntax.db.FruitStorageDd;

import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public Map<String, Integer> getStorage() {
        return FruitStorageDd.fruitStorageDB;
    }

    @Override
    public int getQualityByObjectType(String fruit) {
        return FruitStorageDd.fruitStorageDB.get(fruit);
    }

    @Override
    public void putToStorage(String fruit, int quality) {
        FruitStorageDd.fruitStorageDB.put(fruit, quality);
    }
}
