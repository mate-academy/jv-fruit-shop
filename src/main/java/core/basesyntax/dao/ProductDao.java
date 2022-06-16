package core.basesyntax.dao;

import java.util.Map;
import java.util.Optional;

public interface ProductDao {
    void add(String product, Integer quantity);

    Optional<Integer> get(String product);

    Map<String, Integer> getAll();
}
