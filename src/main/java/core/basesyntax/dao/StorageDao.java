package core.basesyntax.dao;

import java.util.OptionalInt;

public interface StorageDao {
    void set(String key, int quantity);

    void add(String key, int quantity);

    void subtract(String key, int quantity);

    OptionalInt get(String key);
}
