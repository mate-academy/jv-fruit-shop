package core.basesyntax.dao;

import java.util.Map;
import java.util.Optional;

public interface StorageDao {
    void update(String fruit, Integer quantity);

    Optional<Integer> getCurrentQuantity(String fruit);

    Map<String, Integer> getData();
}
