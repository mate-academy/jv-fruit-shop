package core.basesyntax.db;

import core.basesyntax.db.dao.Storage;
import core.basesyntax.model.FruitItem;

import java.util.HashMap;


public class StrorageDaoImpl implements StorageDao {
    private static Long index = 0L;

    @Override
    public HashMap<String, Integer> add(FruitItem fruit) {
        Storage.fruitsQuantity.put(fruit.getFruitName(), fruit.getFruitQuantity());
        return Storage.fruitsQuantity;
    }

    @Override
    public HashMap<String, Integer> get(String fruitName) {
        for (StorageDao) {
            if (fruit.getFruitName().equals(fruitName)) {
                Storage.fruitsQuantity;
            }
        }
        return null;
    }

}
