package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.HashMap;

public class StorageDaoImpl implements StorageDao {

    @Override
    public HashMap<String, Integer> add(String fruitName, Integer quantity) {
        Storage.fruitsQuantity.put(fruitName,quantity);
        return Storage.fruitsQuantity;
    }

    @Override
    public HashMap<String, Integer> get(String fruitName) {
        Integer quantity = Storage.fruitsQuantity.get(fruitName);
        if (quantity != null) {
            HashMap<String, Integer> result = new HashMap<>();
            result.put(fruitName, quantity);
            return result;
        }
        return null;
    }
}
