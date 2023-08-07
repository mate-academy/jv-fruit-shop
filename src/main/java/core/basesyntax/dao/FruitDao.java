package core.basesyntax.dao;

import java.util.Map;
import java.util.Optional;

public interface FruitDao {
    void add(String name, Integer amount);

    Optional<Integer> get(String name);

    Map<String, Integer> getAll();
}
