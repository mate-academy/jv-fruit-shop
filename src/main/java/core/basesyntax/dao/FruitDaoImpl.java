package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void put(String fruitName, Integer fruitQuantity) {
        Storage.storage.put(fruitName, fruitQuantity);
    }

    @Override
    public void summQuantity(String fruitName, Integer fruitQuantity) {
        Integer oldFruitQuantity = Storage.storage.get(fruitName);
        remove(fruitName);
        put(fruitName, fruitQuantity + oldFruitQuantity);
    }

    @Override
    public void subtractQuantity(String fruitName, Integer fruitQuantity) {
        Integer oldFruitQuantity = Storage.storage.get(fruitName);
        remove(fruitName);
        put(fruitName, oldFruitQuantity - fruitQuantity);
    }

    private void remove(String fruit) {
        Storage.storage.remove(fruit);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.storage;
    }
}
