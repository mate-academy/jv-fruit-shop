package core.basesyntax.db.dao;

import java.util.Map;

public interface StorageDao {
    void add(String fruitName, Integer count);

    Map<String, Integer> getInfo();
}
