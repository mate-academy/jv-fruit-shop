package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;

public class StorageDaoImpl implements StorageDao {
    private static final Storage STORAGE = new Storage();

    @Override
    public void addFruit(String fruit, int quantity) {
        if (fruit.isEmpty()) {
            throw new RuntimeException("Fruit can't be null");
        }
        if (quantity < 0) {
            throw new RuntimeException(
                    "Quantity can't be less than 0. Quantity value " + quantity);
        }
        STORAGE.addFruitToStorage(fruit.toLowerCase(), quantity);

    }

    @Override
    public Fruit getFruit(String fruitName) {
        if (fruitName.isEmpty()) {
            throw new RuntimeException("Can't get fruit. Input value is empty");
        }
        return STORAGE.getFruit(fruitName.toLowerCase());
    }

    @Override
    public void update(String fruit, int newQuantity) {
        STORAGE.updateFruit(fruit.toLowerCase(), newQuantity);
    }
}
