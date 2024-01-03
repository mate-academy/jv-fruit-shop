package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class StoreDaoImpl implements StoreDao {

    @Override
    public void addFruits(String nameOfGood, Integer amount) {
        Storage.storage.put(nameOfGood, amount);
    }

    @Override
    public Map<String, Integer> get() {
        return Storage.storage;
    }
}
