package dao;

import db.Storage;
import model.Fruit;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void addNewFruit(Fruit fruit) {
        Storage.storage.add(fruit);
    }

    @Override
    public void changeQuantityOfFruit(Fruit fruit) {
        for (Fruit f : Storage.storage) {
            if (fruit.getFruitType().equals(f.getFruitType())) {
                f.setQuantity(fruit.getOperation()
                        .getActionByOperation(fruit.getQuantity()).applyAsInt(f.getQuantity()));
                return;
            }
        }
        addNewFruit(fruit);
    }
}
