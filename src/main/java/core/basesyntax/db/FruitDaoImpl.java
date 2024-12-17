package core.basesyntax.db;

import core.basesyntax.db.storage.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(String fruit, int quantity) {
        if (!Storage.fruits.containsKey(fruit)) {
            Storage.fruits.put(fruit,quantity);
            return;
        }
        Storage.fruits.compute(fruit, (k, oldQuantity) -> oldQuantity + quantity);
    }

    @Override
    public void subtract(String fruit, int quantity) {
        if (!Storage.fruits.containsKey(fruit)) {
            throw new RuntimeException("There is not enough " + fruit + " in Storage");
        }
        Storage.fruits.compute(fruit, (k, oldQuantity) -> oldQuantity - quantity);
    }

    @Override
    public Map<String, Integer> getStorageQuantity() {
        return Storage.fruits;
    }
}
