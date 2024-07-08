package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;

public class StorageDaoImpl implements StorageDao {
    private static final Storage STORAGE = new Storage();

    @Override
    public void addFruit(String fruit, int quantity) {
        if (fruit.isEmpty()) {
            throw new RuntimeException("Fruit can't be null");
        } else if (STORAGE.getFruit(fruit) != null) {
            update(fruit,quantity);
        } else if (quantity < 0) {
            throw new RuntimeException(
                    "Quantity can't be less than 0. Quantity value " + quantity);
        } else {
            STORAGE.addFruitToStorage(fruit.toLowerCase(), quantity);
        }
    }

    @Override
    public Fruit getFruit(String fruitName) {
        if (fruitName.isEmpty()) {
            throw new RuntimeException("Can't get fruit. Input value is empty");
        }
        Fruit fruit = STORAGE.getFruit(fruitName.toLowerCase());
        if (fruit == null) {
            throw new RuntimeException("Can't get fruit from storage by name " + fruitName);
        } else {
            return fruit;
        }
    }

    @Override
    public void update(String fruit, int newQuantity) {
        if (newQuantity < 0) {
            throw new RuntimeException(
                    "Quantity can't be less than 0. Quantity value " + newQuantity);
        }
        if (STORAGE.getFruit(fruit.toLowerCase()) == null) {
            addFruit(fruit, newQuantity);
        } else {
            STORAGE.updateFruit(fruit.toLowerCase(), newQuantity);
        }
    }
}
