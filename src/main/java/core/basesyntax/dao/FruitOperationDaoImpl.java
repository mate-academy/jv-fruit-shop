package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitOperationDaoImpl implements FruitOperationDao {
    private Storage storage;

    public FruitOperationDaoImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public int get(String fruit) {
        return storage.getFruitStorage().entrySet().stream()
            .filter(whatFruit -> whatFruit.getKey().equals(fruit))
            .map(Map.Entry::getValue)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Fruit " + fruit
                + " record not found"));
    }

    @Override
    public void put(String fruit, Integer quantity) {
        storage.getFruitStorage().remove(fruit);
        storage.getFruitStorage().put(fruit, quantity);
    }

}
