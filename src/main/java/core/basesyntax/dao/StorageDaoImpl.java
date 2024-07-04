package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;

public class StorageDaoImpl implements StorageDao {
    private static final Storage STORAGE = new Storage();

    @Override
    public void addFruit(String fruit, int quantity) {
        STORAGE.addFruitToStorage(fruit, quantity);
    }

    @Override
    public Fruit getFruit(String fruitName) {
        return STORAGE.getFruit(fruitName);
    }

    @Override
    public void update(String fruit, int newQuantity) {
        STORAGE.updateFruit(fruit, newQuantity);
    }
}
