package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitStorageDaoImpl implements FruitStorageDao {

    @Override
    public void put(String fruit, int amount) {
        if (Storage.fruitList.isEmpty()) {
            Storage.fruitList.put(fruit, amount);
            return;
        }
        for (Map.Entry<String, Integer> item : Storage.fruitList.entrySet()) {
            if (item.getKey().equals(fruit)) {
                item.setValue(item.getValue() + amount);
            }
        }
    }

    @Override
    public void remove(String fruit, int amount) {
        for (Map.Entry<String, Integer> item: Storage.fruitList.entrySet()) {
            if (item.getKey().equals(fruit)) {
                item.setValue(item.getValue() - amount);
            }
        }
    }

    @Override
    public Map<String, Integer> getDataFromStorage() {
        return Storage.fruitList;
    }
}
