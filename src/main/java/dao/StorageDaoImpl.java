package dao;


import db.Storage;
import model.Fruit;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void update(Fruit fruit, int quantity) {
        Storage.dataBase.compute(fruit, (key, val) -> val == null ? quantity : val + quantity);
    }
}
