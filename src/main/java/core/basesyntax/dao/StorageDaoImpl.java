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
    public Integer get(String fruitName) {
        return Storage.fruitsQuantity.get(fruitName);
    }
}
