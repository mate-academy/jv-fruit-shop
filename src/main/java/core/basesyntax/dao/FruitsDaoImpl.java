package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class FruitsDaoImpl implements FruitsDao {

    @Override
    public void add(FruitTransaction fruits) {
        Storage.STORAGE.put(fruits.getName(), fruits.getQuantity());
    }

    @Override
    public Integer get(String fruitsName) {
        return Storage.STORAGE.get(fruitsName);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.STORAGE;
    }

    @Override
    public void set(String fruitsName, Integer quantity) {
        Storage.STORAGE.put(fruitsName, quantity);
    }
}
