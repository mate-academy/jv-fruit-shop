package com.basesyntax.db;

import com.basesyntax.model.Fruit;
import java.util.List;
import java.util.Map;

public interface Storage {
    Map<Fruit, Integer> getStorage();

    List<String> getStorageAsList();
}
