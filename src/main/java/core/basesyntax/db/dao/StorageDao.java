package core.basesyntax.db.dao;

import core.basesyntax.model.FruitTransaction;

import java.util.Map;

public interface StorageDao {
    void add(String fruitName, Long count);
    Map<String, Long> getInfo();
}
