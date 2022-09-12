package core.basesyntax.dao.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.storage.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void updateDataStorage(String descriptionOfGoods, Integer quantity) {
        Storage.storage.put(descriptionOfGoods, quantity);
    }

    @Override
    public Integer getRemainingGoods(String descriptionOfGoods) {
        return Storage.storage.get(descriptionOfGoods);
    }

    @Override
    public Map<String, Integer> getAllData() {
        return Storage.storage;
    }
}
