package core.basesyntax.dao;

import java.util.List;
import java.util.Optional;

public interface StorageDao<T> {
    boolean put(T value);

    Optional<T> remove(int index);

    List<T> getAll();
}
