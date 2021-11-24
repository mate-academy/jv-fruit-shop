package core.basesyntax.dao;

import java.util.Optional;

public interface StorageDao {
    void add(String name, Integer quantity);

    Optional<Integer> get(String name);

    void update(String name, Integer quantity);

    boolean contains(String name);
}
