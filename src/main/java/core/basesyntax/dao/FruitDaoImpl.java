package core.basesyntax.dao;

import core.basesyntax.database.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void put(String fruitName, int quantity) {
        Storage.fruitsStorage.put(fruitName,quantity);
    }

    @Override
    public int getFruitQuantity(String fruitName) {
        return Storage.fruitsStorage.entrySet().stream()
                .filter(f -> f.getKey().equals(fruitName))
                .map(f -> f.getValue())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No such fruit in Storage " + fruitName));
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.fruitsStorage;
    }
}
