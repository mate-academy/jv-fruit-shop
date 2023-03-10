package com.mate.fruitshop.dao.impl;

import com.mate.fruitshop.dao.FruitStorageDao;
import com.mate.fruitshop.db.Storage;
import com.mate.fruitshop.model.FruitEntry;
import java.util.Collections;
import java.util.List;

public class FruitStorageDaoImpl implements FruitStorageDao {
    @Override
    public FruitEntry getEntryByFruitName(String fruitName) {
        return Storage.FRUITS.stream()
                .filter(f -> f.getFruitName().equals(fruitName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean addFruitEntry(FruitEntry fruitEntry) {
        return Storage.FRUITS.add(fruitEntry);
    }

    @Override
    public List<FruitEntry> getAllFruitEntries() {
        return Collections.unmodifiableList(Storage.FRUITS);
    }
}
