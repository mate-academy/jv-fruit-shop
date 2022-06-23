package dao;

import db.Storage;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(String name, Integer amount) {
        Storage.report.put(name, amount);
    }
}
