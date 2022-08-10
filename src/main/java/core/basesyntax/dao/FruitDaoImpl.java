package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {

    @Override
    public void add(Map<String, Integer> fruits) {
        Storage.fruits.putAll(fruits);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.fruits;
    }
}
