package dao.impl;

import dao.StorageDao;
import db.Storage;
import java.util.List;
import model.FruitTransaction;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void addTransaction(FruitTransaction transaction) {
        Storage.storage.add(transaction);
    }

    @Override
    public List<FruitTransaction> getAllTransaction() {
        return Storage.storage;
    }

    @Override
    public void clearDataBase() {
        Storage.storage.clear();
    }
}
