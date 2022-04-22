package core.basesyntax.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    T create(T element);

    Optional<T> get(T key);

    List<T> getAll();

    T update(T element);

    boolean delete(T key);
}
