package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface StorageDao {
    void add(FruitTransaction transaction);

    Integer get(FruitTransaction transaction);

    Map<String, Integer> getStorage();
}

