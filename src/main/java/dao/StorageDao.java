package dao;

import db.Storage;
import java.util.Map;

public class StorageDao implements DbDao {
    @Override
    public Map<String, Integer> getData() {
        return Storage.getInstance().getFruitStorage();
    }

    @Override
    public void updateData(Map<String, Integer> data) {
        Storage.getInstance().setFruitStorage(data);
    }
}
