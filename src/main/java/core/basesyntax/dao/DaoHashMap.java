package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class DaoHashMap implements Dao {
    @Override
    public void clear() {
        Storage.storage.clear();
    }

    @Override
    public void add(String fruit, Integer quantity) {
        Storage.storage.put(fruit, quantity);
    }

    @Override
    public Integer getQuantity(String fruit) {
        Integer quantity = Storage.storage.get(fruit);
        return quantity == null ? 0 : quantity;
    }

    @Override
    public Map<String, Integer> getData() {
        return Storage.storage;
    }
}

