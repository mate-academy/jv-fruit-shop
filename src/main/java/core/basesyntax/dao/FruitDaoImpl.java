package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {

    @Override
    public void add(String fruitName, Integer fruitQuantity) {
        Storage.fruits.put(fruitName, fruitQuantity);
    }

    @Override
    public Map<String, Integer> getFromStorage() {
        return Storage.fruits;
    }
}
