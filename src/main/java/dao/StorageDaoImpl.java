package dao;

import java.util.List;
import db.Storage;
import model.FruitTransaction;


public class StorageDaoImpl implements StorageDao {
    @Override
    public void putTransfer(FruitTransaction transaction) {
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
