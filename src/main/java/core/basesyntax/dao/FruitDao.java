package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    void add(String nameFruit, int amount);

    Map<String, Integer> getAll();

    Integer get(String nameFruit);
}
