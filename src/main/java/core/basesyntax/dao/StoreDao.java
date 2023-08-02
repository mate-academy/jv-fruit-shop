package core.basesyntax.dao;

import java.util.Map;

public interface StoreDao {
    boolean add(String key, Integer value);

    Map<String, Integer> getStorage();

    boolean clean();
}
