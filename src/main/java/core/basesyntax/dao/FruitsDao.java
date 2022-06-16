package core.basesyntax.dao;

import java.util.Map;

public interface FruitsDao {

    void add(String fruit, int amount);

    int get(String fruit);

    void remove(String fruit);

    boolean isAvailable(String fruit);

    Map<String, Integer> getFruitsAndQuantityAsMap();
}
