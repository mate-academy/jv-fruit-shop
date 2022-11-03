package core.basesyntax.dao;

import java.util.Map;
import java.util.Optional;

public interface StorageDao {
    Map<String, Integer> getAll();

    Optional<Integer> getQuantity(String product);

    void update(String product, Integer quantity);

    void delete(String product);
}
