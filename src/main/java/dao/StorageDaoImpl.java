package dao;

import storage.Storage;

public class StorageDaoImpl implements StorageDao{
    @Override
    public void put(String name, Integer amount) {
        Storage.put(name,amount);
    }

    @Override
    public Integer get(String name) {
       return Storage.fruits.get(name);
    }

    @Override
    public String getFruitReport() {
        return Storage.stringReport();
    }
}
