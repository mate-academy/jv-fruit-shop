package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.db.Storage;
import java.util.Map;
import java.util.Set;

public class FruitDaoImpl implements FruitsDao {
    @Override
    public void save(String fruitName, int amount) {
        Storage.fruitsStorage.put(fruitName, amount);
    }

    @Override
    public int get(String fruitName) {
        Integer amount = Storage.fruitsStorage.get(fruitName);
        return amount == null ? 0 : amount;
    }

    @Override
    public Set<Map.Entry<String, Integer>> getAll() {
        return Storage.fruitsStorage.entrySet();
    }

}
