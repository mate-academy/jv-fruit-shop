package core.basesyntax.dao.storagedao;

import java.util.Map;

public interface FruitStorageDao {
    void putToStorage(String name, Integer quantity);
    void removeToStorage(String name);
    Integer get(String name);
    Map<String, Integer> getAllStorage();
    boolean containsKey(String name);

}
