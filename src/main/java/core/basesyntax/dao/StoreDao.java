package core.basesyntax.dao;

import java.util.Map;

public interface StoreDao {
    void add(String key, Integer value);

    Map<String, Integer> getStorage();

    void clean();
}
