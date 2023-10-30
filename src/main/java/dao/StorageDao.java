package dao;

import db.Storage;
import java.util.Map;

public class StorageDao implements Dao {
    @Override
    public Map<String, Integer> getStock() {
        return Storage.getInstance().getFruitStorage();
    }

    @Override
    public void updateStock(Map<String, Integer> data) {
        Storage.getInstance().setFruitStorage(data);
    }
}
