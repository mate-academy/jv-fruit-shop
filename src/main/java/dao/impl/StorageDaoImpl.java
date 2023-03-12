package dao.impl;

import static db.DataBase.storage;

import dao.StorageDao;
import db.DataBase;
import java.util.List;
import java.util.stream.Collectors;

public class StorageDaoImpl implements StorageDao {
    private static final String SEPEARATOR = ",";

    @Override
    public int get(String fruit) {
        return DataBase.storage.get(fruit);
    }

    @Override
    public List<String> getAll() {
        return DataBase.storage.entrySet()
                .stream()
                .map(i -> i.getKey() + SEPEARATOR + i.getValue() + System.lineSeparator())
                .collect(Collectors.toList());
    }

    @Override
    public void add(String fruit, int value) {
        storage.put(fruit, value);
    }

    @Override
    public void update(String fruit, int value) {
        storage.put(fruit, value);
    }

    @Override
    public boolean hasFruit(String fruit) {
        return storage.containsKey(fruit);
    }
}

