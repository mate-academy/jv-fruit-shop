package core.basesyntax.dao;

import java.util.Map;

public interface StorageDao {

    void putToMap(String fruit, Integer amount);

    Integer getAmount(String fruit);

    Map<String, Integer> getAll();
}
