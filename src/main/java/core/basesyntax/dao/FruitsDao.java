package core.basesyntax.dao;

import java.util.Map;

public interface FruitsDao {

    void add(String fruit, int amount);

    void subtract(String fruit, int amount);

    Map<String, Integer> checkStorage();
}
