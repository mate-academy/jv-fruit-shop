package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(String nameFruit, int amount) {
        Storage.fruits.put(nameFruit, Storage.fruits.get(nameFruit) + amount);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.fruits;
    }

    @Override
    public Integer get(String nameFruit) {
        return Storage.fruits.get(nameFruit) == null ? -1 : Storage.fruits.get(nameFruit);
    }
}
