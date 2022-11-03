package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class StorageDaoImpl implements StorageDao {

    @Override
    public void addFruitQuantity(FruitTransaction fruitTransaction) {
        String key = fruitTransaction.getFruit();
        int oldQuantity = Storage.fruits.get(key);
        Storage.fruits.put(key, fruitTransaction.getQuantity() + oldQuantity);
    }

    @Override
    public void subtractFruitQuantity(FruitTransaction fruitTransaction) {
        String key = fruitTransaction.getFruit();
        int oldQuantity = Storage.fruits.get(key);
        Storage.fruits.put(key, oldQuantity - fruitTransaction.getQuantity());
    }

    @Override
    public void putFruit(FruitTransaction fruit) {
        Storage.fruits.put(fruit.getFruit(), fruit.getQuantity());
    }
}
