package core.basesyntax.db;

import core.basesyntax.db.dao.Storage;
import core.basesyntax.model.FruitItem;

import java.util.HashMap;
import java.util.Map;


public class StrorageDaoImpl implements StorageDao {

    @Override
    public HashMap<String, Integer> add(FruitItem fruit) {
        Storage.fruitsQuantity.put(fruit.getFruitName(), fruit.getFruitQuantity());
        return Storage.fruitsQuantity;
    }

    @Override
    public HashMap<String, Integer> get(FruitItem fruitName) {
        for (Map.Entry<String, Integer> fruit : Storage.fruitsQuantity.entrySet()) {
            if (fruit.getKey().equals(fruitName)) {
                return Storage.fruitsQuantity;
            }
        }
        return null;
    }
}
