package core.basesyntax.db.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {

    @Override
    public void set(String fruitName, Integer fruitAmount) {
        Storage.fruitMap.put(fruitName,fruitAmount);
    }

    @Override
    public Integer get(String fruitName) {
        return Storage.fruitMap.get(fruitName);
    }

    public Map<String, Integer> getAll() {
        return Storage.fruitMap;
    }

}
