package core.basesyntax.db;

import java.util.Map;
import java.util.Set;

public class DaoImpl implements Dao {
    @Override
    public boolean addEntry(String fruitName, int quantity) {
        Storage.fruitStorage.put(fruitName, quantity);
        return true;
    }

    @Override
    public boolean removeEntry(String fruitName) {
        int value = Storage.fruitStorage.remove(fruitName);
        return true;
    }

    @Override
    public boolean isStorageEmpty() {
        return Storage.fruitStorage.isEmpty();
    }

    @Override
    public boolean isFruitPresent(String fruitName) {
        return Storage.fruitStorage.containsKey(fruitName);
    }

    @Override
    public int getFruitQuantity(String fruitName) {
        return Storage.fruitStorage.get(fruitName);
    }

    @Override
    public Set<Map.Entry<String, Integer>> getAllEntries() {
        return Storage.fruitStorage.entrySet();
    }
}
