package dao;

import db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {

    @Override
    public void update(String name, Integer newAmount) {
        Storage.report.put(name, newAmount);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.report;
    }
}
