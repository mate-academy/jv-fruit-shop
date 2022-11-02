package dao.impl;

import dao.FruitStorageDao;
import db.Storage;
import java.util.List;
import java.util.stream.Collectors;

public class FruitStorageDaoImpl implements FruitStorageDao {
    private static final String SPLITERATOR = ",";

    @Override
    public int getNumer(String fruit) {
        return Storage.storage.get(fruit);
    }

    @Override
    public List<String> getAll() {
        return Storage.storage.entrySet().stream()
                .map(e -> e.getKey() + SPLITERATOR + e.getValue() + System.lineSeparator())
                .collect(Collectors.toList());
    }

    @Override
    public void save(String fruit, int number) {
        Storage.storage.put(fruit, number);
    }

    @Override
    public void update(String fruit, int number) {
        Storage.storage.put(fruit, number);
    }

    @Override
    public boolean hasInDb(String fruit) {
        return Storage.storage.containsKey(fruit);
    }
}
