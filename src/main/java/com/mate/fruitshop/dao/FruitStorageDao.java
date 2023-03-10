package com.mate.fruitshop.dao;

import com.mate.fruitshop.model.FruitEntry;
import java.util.List;

public interface FruitStorageDao {
    FruitEntry getEntryByFruitName(String fruitName);

    boolean addFruitEntry(FruitEntry fruitEntry);

    List<FruitEntry> getAllFruitEntries();
}
