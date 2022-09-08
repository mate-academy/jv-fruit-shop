package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;
import java.util.NoSuchElementException;

public class FruitStorageDaoImpl implements FruitStorageDao {
    @Override
    public void add(String fruit, Integer amount) {
        Integer currentQuantity = Storage.fruitMap.get(fruit) == null ? 0
                : Storage.fruitMap.get(fruit);
        Storage.fruitMap.put(fruit, currentQuantity + amount);
    }

    @Override
    public void remove(String fruit, Integer amount) {
        Integer currentQuantity = Storage.fruitMap.get(fruit);
        if (currentQuantity == null || currentQuantity < amount) {
            throw new NoSuchElementException("Current quantity: " + currentQuantity
                    + "purchase fruit: " + amount + ". Fruit is not enough.");
        }
        Storage.fruitMap.put(fruit, currentQuantity - amount);
    }

    @Override
    public Map<String, Integer> getDataFromStorage() {
        return Storage.fruitMap;
    }
}
