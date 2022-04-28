package core.basesyntax.dao;

import java.util.List;

public interface StorageDao {
    void add(String fruit, int amount);

    int getAmount(String key);

    boolean isPresent(String key);

    List<String> getAll();
}
