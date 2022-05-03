package dao;

import db.Storage;

public class FruitsDaoImpl implements FruitsDao {

    @Override
    public void addProduct(String product, Integer count) {
        Storage.storage.put(product, count);
    }

    @Override
    public Integer getValue(String product) {
        return Storage.storage.get(product);
    }
}
