package core.basesyntax.dao;

import java.util.Map;

public interface StorageDao {
    void add(String fruit, Integer amount);
    void supply(String fruit, Integer amount);
    void remove(String fruit, Integer amount);
    Map<String, Integer> getData();
}
