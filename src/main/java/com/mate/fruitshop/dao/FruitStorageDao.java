package com.mate.fruitshop.dao;

import com.mate.fruitshop.model.FruitEntry;
import java.util.List;

public interface FruitStorageDao {
    FruitEntry getByName(String fruitName);

    void add(FruitEntry fruitEntry);

    List<FruitEntry> getAll();
}
