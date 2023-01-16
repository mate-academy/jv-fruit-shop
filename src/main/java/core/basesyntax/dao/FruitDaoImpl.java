package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.HashMap;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void replaceValue(String name, Integer quantity) {
        Storage.fruitStorage.put(name, quantity);
    }

    @Override
    public Integer getQuantity(String name) {
        return Storage.fruitStorage.get(name);
    }

    @Override
    public Map<String, Integer> getMap() {
        return new HashMap<>(Storage.fruitStorage);
    }
}
