package core.basesyntax.dao;

import java.util.Map;

public interface FruitRepository {
    void add(String fruit, int quantity);

    void remove(String fruit, int quantity);

    boolean hasFruit(String fruit);

    Map<String, Integer> getAll();
}
