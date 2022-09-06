package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;
import java.util.NoSuchElementException;

public class FruitStorageDaoImpl implements FruitStorageDao {

    @Override
    public void put(String fruit, Integer amount) {
        Integer currentQuantity = Storage.fruitList.get(fruit) == null ? 0
                : Storage.fruitList.get(fruit);
        Storage.fruitList.put(fruit, currentQuantity + amount);
    }

    @Override
    public void remove(String fruit, Integer amount) {
        Integer currentQuantity = Storage.fruitList.get(fruit);
        if (currentQuantity == null || currentQuantity < amount) {
            throw new NoSuchElementException("Quantity of fruits is not enough for purchase");
        }
        Storage.fruitList.put(fruit, currentQuantity - amount);
    }

    @Override
    public Map<String, Integer> getDataFromStorage() {
        return Storage.fruitList;
    }
}
