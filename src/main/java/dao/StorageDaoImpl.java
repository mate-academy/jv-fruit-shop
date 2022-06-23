package dao;

import db.Storage;
import model.Fruit;

public class StorageDaoImpl implements StorageDao {
    @Override
    public Fruit getFruit(Fruit fruit) {
        for (Fruit f : Storage.storage) {
            if (f.getFruitType().equals(fruit.getFruitType())) {
                return f;
            }
        }
        return null;
    }

    @Override
    public void changeQuantityOfFruit(Fruit fruit) {
        getFruit(fruit).setQuantity(fruit.getQuantity());
    }

    @Override
    public void addFruit(Fruit fruit) {
        Storage.storage.add(fruit);
    }
}
