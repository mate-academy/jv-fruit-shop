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
            throw new RuntimeException("There isn't " + fruit + " in Storage");
        }
        int oldQuantity = Storage.fruits.get(fruit);
        if (quantity > oldQuantity) {
            throw new RuntimeException("There isn't enough "
                    + fruit
                    + " in Storage, you can buy "
                    + oldQuantity);
        }
        Storage.fruits.put(fruit,oldQuantity - quantity);
    }

    @Override
    public Map<String, Integer> getStorageQuantity() {
        return Storage.fruits;
    }
}
