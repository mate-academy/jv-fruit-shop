package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitsDaoImpl implements FruitsDao {
    private final Storage storage;

    public FruitsDaoImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void balance(String fruit, int quantity) {
        storage.setFruitsQuantity(fruit, quantity);
    }

    @Override
    public void supply(String fruit, int quantity) {
        storage.increaseFruitsQuantity(fruit, quantity);
    }

    @Override
    public void purchase(String fruit, int quantity) {
        storage.decreaseFruitsQuantity(fruit, quantity);
    }

    @Override
    public void returnFruits(String fruit, int quantity) {
        storage.increaseFruitsQuantity(fruit, quantity);
    }

    @Override
    public Map<String, Integer> getInventory() {
        return storage.getFruitsInventory();
    }
}
