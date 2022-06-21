package dao;

import db.Storage;

public class StorageDaoImpl implements StorageDao {

    @Override
    public void addNewFruit(String fruit, int quantity) {
        Storage.put(fruit, quantity);
    }

    @Override
    public void changeQuantityOfFruit(String fruit, int quantity) {
        if (Storage.get(fruit) == null) {
            addNewFruit(fruit, quantity);
            return;
        }
        Storage.put(fruit, Storage.get(fruit) + quantity);
    }

}
