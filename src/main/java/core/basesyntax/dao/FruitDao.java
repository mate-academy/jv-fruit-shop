package core.basesyntax.dao;

import java.util.Map;
import java.util.Set;

public interface FruitDao {

    void put(String fruit, int amount);

    int get(String fruit);

    boolean isContains(String fruit);

    Set<Map.Entry<String,Integer>> getEntrySet();
}
