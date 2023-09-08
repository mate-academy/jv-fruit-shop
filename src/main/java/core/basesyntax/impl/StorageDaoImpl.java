package core.basesyntax.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.db.Storage;
import java.util.ArrayList;
import java.util.List;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void putFruit(String key, Integer value) {
        Storage.addFruit(key, value);
    }

    @Override
    public List<String> getAllFruits() {
        return new ArrayList<>(Storage.getFruits().entrySet())
                .stream()
                .map(Object::toString)
                .toList();
    }

    @Override
    public Integer getFruitAmount(String fruitName) {

        return Storage.getQuantityBy(fruitName);
    }
}
