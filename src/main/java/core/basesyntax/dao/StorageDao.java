package core.basesyntax.dao;

import java.util.Map;

public interface StorageDao {
    void update(String fruit,Integer count);

    boolean checkFruit(String fruit);

    void createFruit(String fruit);

    Integer getCountFruit(String fruit);

    Map<String, Integer> getAllFruitsFromStorage();
}
