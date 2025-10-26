package core.basesyntax.dao.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {

    @Override
    public void setFruitQuantity(String fruit, int quantity) {
        checkInputFruit(fruit);
        if (quantity < 0) {
            throw new RuntimeException("Quantity to set cannot be negative");
        }
        Storage.putFruitQuantity(fruit, quantity);
    }

    @Override
    public void addFruitQuantity(String fruit, int quantity) {
        checkInputFruit(fruit);
        if (quantity <= 0) {
            throw new RuntimeException("Quantity to add should be positive");
        }
        Storage.putFruitQuantity(fruit, getFruitQuantity(fruit) + quantity);
    }

    @Override
    public void deductFruitQuantity(String fruit, int quantity) {
        checkInputFruit(fruit);
        if (quantity <= 0) {
            throw new RuntimeException("Quantity to deduct should be positive");
        }
        if (quantity > getFruitQuantity(fruit)) {
            throw new RuntimeException("Quantity to deduct should be less "
                    + "than the current storage quantity");
        }
        Storage.putFruitQuantity(fruit, getFruitQuantity(fruit) - quantity);
    }

    @Override
    public int getFruitQuantity(String fruit) {
        checkInputFruit(fruit);
        return Storage.getFruitQuantity(fruit);
    }

    @Override
    public Map<String, Integer> getAllFruitsQuantities() {
        return Storage.getAllFruitsQuantities();
    }

    private void checkInputFruit(String fruit) {
        if (fruit == null) {
            throw new RuntimeException("Unable to complete operation: parameter 'fruit' is null");
        }
    }
}
