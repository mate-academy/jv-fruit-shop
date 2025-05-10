package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Set;

public class FruitStorageDaoImpl implements FruitStorageDao {
    @Override
    public boolean setBalance(Fruit fruit, int quantity) {
        Storage.fruits.put(fruit, quantity);
        return Storage.fruits.get(fruit) == quantity;
    }

    @Override
    public boolean add(Fruit fruit, int quantity) {
        checkFruitBelongToStorage(fruit);
        int oldValue = Storage.fruits.get(fruit);
        int newValue = oldValue + quantity;
        Storage.fruits.put(fruit, newValue);
        return Storage.fruits.get(fruit) == newValue;
    }

    @Override
    public boolean subtract(Fruit fruit, int quantity) {
        checkFruitBelongToStorage(fruit);
        int oldValue = Storage.fruits.get(fruit);
        int newValue = oldValue - quantity;
        Storage.fruits.put(fruit, newValue);
        return Storage.fruits.get(fruit) == newValue;
    }

    @Override
    public int getBalance(Fruit fruit) {
        checkFruitBelongToStorage(fruit);
        return Storage.fruits.get(fruit);
    }

    @Override
    public Set<Fruit> getAllFruits() {
        return Storage.fruits.keySet();
    }

    private void checkFruitBelongToStorage(Fruit fruit) {
        if (Storage.fruits.get(fruit) == null) {
            throw new RuntimeException("Fruit " + fruit + " doesn't belong "
                    + "to the Storage");
        }
    }
}
