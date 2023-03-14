package com.mate.fruitshop.dao.impl;

import com.mate.fruitshop.dao.FruitStorageDao;
import com.mate.fruitshop.db.Storage;
import com.mate.fruitshop.model.FruitEntry;
import java.util.Collections;
import java.util.List;

public class FruitStorageDaoImpl implements FruitStorageDao {
    @Override
    public FruitEntry getByName(String fruitName) {
        return Storage.fruits.stream()
                .filter(f -> f.getFruitName().equals(fruitName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void add(FruitEntry fruitEntry) {
        Storage.fruits.add(fruitEntry);
    }

    @Override
    public List<FruitEntry> getAll() {
        return Collections.unmodifiableList(Storage.fruits);
    }
}
