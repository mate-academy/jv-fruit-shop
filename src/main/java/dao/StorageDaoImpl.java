package dao;

import db.Storage;
import java.util.Map;
import java.util.Set;
import model.Fruit;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void update(Fruit fruit, int quantity) {
        Storage.dataBase.compute(fruit, (key, val) -> val == null ? quantity : val + quantity);
    }

    @Override
    public Set<Map.Entry<Fruit, Integer>> getAll() {
        return Storage.dataBase.entrySet();
    }

    @Override
    public Integer get(Fruit fruit) {
        return Storage.dataBase.get(fruit);
    }
}
