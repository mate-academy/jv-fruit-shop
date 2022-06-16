package core.basesyntax.dao;

import java.util.Map;

public interface FruitsDao {

    boolean add(String fruit, int amount);

    int get(String fruit);

    boolean remove(String fruit);

    Map<String, Integer> getFruitsAndQuantityAsMap();
}
