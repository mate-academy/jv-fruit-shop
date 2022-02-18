package dao;

import db.Storage;
import java.util.Map;

public class WokWithStorageImpl implements WorkWithStorageDB {

    @Override
    public void addInStorage(String fruits, Integer quantity) {
        Storage.storageDB.put(fruits,quantity);
    }

    @Override
    public Integer getFromStorage(String fruit) {
        return Storage.storageDB.get(fruit);
    }

    @Override
    public Map<String,Integer> getAllFromStorage() {
        return Storage.storageDB;
    }
}
