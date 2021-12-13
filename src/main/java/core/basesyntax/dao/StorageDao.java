package core.basesyntax.dao;

import core.basesyntax.model.product.Fruit;
import java.util.Map;
import java.util.Optional;

public interface StorageDao {
    void add(Fruit fruit, int count);

    Optional<Integer> get(Fruit fruit);

    Map<Fruit, Integer> getAll();
}
