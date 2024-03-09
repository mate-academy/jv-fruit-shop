package core.basesyntax.dao.impl;

import core.basesyntax.bd.Storage;
import core.basesyntax.dao.FruitDao;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(String fruit, int quantity) {
        Storage.storageFruits.put(fruit, quantity);
    }

    public int get(String fruit) {
        return Storage.storageFruits.get(fruit);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.storageFruits;
    }
}
