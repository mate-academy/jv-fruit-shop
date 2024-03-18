package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitItem;

import java.util.HashMap;
import java.util.Map;


public class StorageDaoImpl implements StorageDao {

    @Override
    public HashMap<String, Integer> add(FruitItem fruit) {
        Storage.fruitsQuantity.putAll(fruit);
        return Storage.fruitsQuantity;
    }

    @Override
    public HashMap<String, Integer> get(FruitItem fruitName) {
        for (Map.Entry<String, Integer> fruit : Storage.fruitsQuantity.entrySet()) {
            if (fruit.getKey().equals(fruitName.getFruitName())) {
                return Storage.fruitsQuantity;
            }
        }
        return null;
    }
}
